package org.delicious.plugin.template;

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate;
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.*;
import com.intellij.refactoring.rename.RenameProcessor;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class RenameTemplate extends PostfixTemplate {

    private final Function<String, String> namingStrategy;

    public RenameTemplate(@NotNull String id,
                          @NotNull String suffix,
                          @NotNull String description,
                          @NotNull PostfixTemplateProvider provider,
                          Function<String, String> namingStrategy) {
        super(id, suffix, description, provider);
        this.namingStrategy = namingStrategy;
    }

    @Override
    public boolean isApplicable(@NotNull PsiElement context, @NotNull Document copyDocument, int newOffset) {
        if (!(context instanceof PsiIdentifier)) {
            return false;
        }
        PsiElement parent = context.getParent();
        return parent instanceof PsiVariable
                || parent instanceof PsiMethod
                || parent instanceof PsiClass
                || (parent instanceof PsiReferenceExpression &&
                    ((PsiReferenceExpression) parent).resolve() instanceof PsiNamedElement);
    }

    @Override
    public void expand(@NotNull PsiElement context, @NotNull Editor editor) {
        PsiElement target = resolveTargetElement(context);
        if (!(target instanceof PsiNamedElement namedElement)) {
            return;
        }

        String oldName = namedElement.getName();
        if (oldName == null || oldName.isEmpty()) {
            return;
        }

        String newName = namingStrategy.apply(oldName);
        if (oldName.equals(newName)) {
            return;
        }

        new RenameProcessor(namedElement.getProject(), namedElement, newName, false, false).run();
    }

    private PsiElement resolveTargetElement(PsiElement context) {
        PsiElement parent = context.getParent();
        if (parent instanceof PsiVariable || parent instanceof PsiMethod || parent instanceof PsiClass) {
            return parent;
        }
        if (parent instanceof PsiReferenceExpression ref) {
            PsiElement resolved = ref.resolve();
            if (resolved instanceof PsiNamedElement) {
                return resolved;
            }
        }
        return null;
    }
}
