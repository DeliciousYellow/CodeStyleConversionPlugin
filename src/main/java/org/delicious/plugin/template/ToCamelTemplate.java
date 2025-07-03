package org.delicious.plugin.template;

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import org.delicious.plugin.util.ConvertUtils;

public class ToCamelTemplate extends RenameTemplate {
    public ToCamelTemplate(PostfixTemplateProvider provider) {
        super("toCamelCase", ".camel", "SNAKE_CASE.camel → snakeCase", provider, ConvertUtils::toCamelCase);
    }
}