class DeliciousPostfixTemplateProvider : PostfixTemplateProvider {
    private val templates = setOf(CamelToSnakeTemplate())

    override fun getTemplates(): Set<PostfixTemplate> = templates

    override fun preExpand(file: PsiFile, editor: Editor) {}
    override fun afterExpand(file: PsiFile, editor: Editor) {}
    override fun isTerminalSymbol(currentChar: Char): Boolean = currentChar == '.'
}
