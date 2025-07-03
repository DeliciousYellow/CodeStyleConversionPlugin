package org.delicious.plugin.provider;

import com.google.common.collect.ImmutableSet;
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate;
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import com.intellij.codeInsight.template.postfix.templates.editable.PostfixTemplateEditor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.NlsActions;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiFile;
import org.delicious.plugin.template.CamelToKebabTemplate;
import org.delicious.plugin.template.CamelToSnakeTemplate;
import org.delicious.plugin.template.ToCamelTemplate;
import org.delicious.plugin.template.ToPascalTemplate;
import org.jdom.Element;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class DeliciousPostfixTemplateProvider implements PostfixTemplateProvider {

    @Override
    public @NotNull Set<PostfixTemplate> getTemplates() {
        return ImmutableSet.of(
                new CamelToSnakeTemplate(this),
                new CamelToKebabTemplate(this),
                new ToCamelTemplate(this),
                new ToPascalTemplate(this)
        );
    }

    @Override
    public boolean isTerminalSymbol(char c) {
        // 定义后缀模板触发的终结符，通常是点号 . ，这里用false表示不特别限制
        return false;
    }

    @Override
    public void preExpand(@NotNull PsiFile psiFile, @NotNull Editor editor) {
        // 展开模板之前的操作，通常为空即可
    }

    @Override
    public void afterExpand(@NotNull PsiFile psiFile, @NotNull Editor editor) {
        // 展开模板之后的操作，通常为空即可
    }

    @Override
    public @NotNull PsiFile preCheck(@NotNull PsiFile psiFile, @NotNull Editor editor, int offset) {
        // 展开前的检查，通常直接返回传入的 psiFile
        return psiFile;
    }

    @Override
    public @NotNull @NonNls String getId() {
        // 插件或模板提供者的唯一ID，建议自定义，不能与其他插件冲突
        return "org.delicious.plugin.DeliciousPostfixTemplateProvider";
    }

    @Override
    public @Nullable @NlsActions.ActionText String getPresentableName() {
        // 在IDE设置中显示的名字
        return "Delicious Postfix Templates";
    }

    @Override
    public @Nullable PostfixTemplateEditor createEditor(@Nullable PostfixTemplate templateToEdit) {
        // 如果想让用户编辑模板，返回对应编辑器实例；不支持则返回null
        return null;
    }

    @Override
    public @Nullable PostfixTemplate readExternalTemplate(@NotNull @NonNls String id,
                                                          @NotNull @NlsSafe String name,
                                                          @NotNull Element templateElement) {
        // 从XML读取模板，默认返回null，表示不支持自定义读取
        return null;
    }

    @Override
    public void writeExternalTemplate(@NotNull PostfixTemplate template, @NotNull Element parentElement) {
        // 保存模板到XML，通常空实现表示不支持
    }
}
