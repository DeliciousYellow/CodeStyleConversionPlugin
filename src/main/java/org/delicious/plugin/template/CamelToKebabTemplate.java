package org.delicious.plugin.template;

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import org.delicious.plugin.util.ConvertUtils;

public class CamelToKebabTemplate extends RenameTemplate {
    public CamelToKebabTemplate(PostfixTemplateProvider provider) {
        super("camelToKebab", ".kebab", "camelCase.kebab → camel-case", provider, ConvertUtils::toKebabCase);
    }
}