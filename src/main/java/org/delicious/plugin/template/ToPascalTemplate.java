package org.delicious.plugin.template;

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import org.delicious.plugin.template.RenameTemplate;
import org.delicious.plugin.util.ConvertUtils;

public class ToPascalTemplate extends RenameTemplate {
    public ToPascalTemplate(PostfixTemplateProvider provider) {
        super("toPascalCase", ".pascal", "SNAKE_CASE.pascal → SnakeCase", provider, ConvertUtils::toPascalCase);
    }
}