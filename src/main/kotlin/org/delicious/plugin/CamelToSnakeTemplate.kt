class CamelToSnakeTemplate :
        PostfixTemplate(".snake", "Convert to UPPER_SNAKE_CASE", selectorAllExpressions()) {

    override fun expandForChooseExpression(expression: PsiElement, editor: Editor) {
        val camel = expression.text

        val result = camel.replace(
                "(?<=[a-z0-9])(?=[A-Z])".toRegex(), "_"
        ).replace(
                "(?<=[A-Z])(?=[A-Z][a-z])".toRegex(), "_"
        ).uppercase()

        val document = editor.document
        WriteCommandAction.runWriteCommandAction(expression.project) {
            document.replaceString(
                    expression.textRange.startOffset,
                    expression.textRange.endOffset,
                    result
            )
        }

    }
}
