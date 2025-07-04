package org.delicious.plugin.template;

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import org.delicious.plugin.util.ConvertUtils;

public class CamelToSnakeTemplate extends RenameTemplate {
    public CamelToSnakeTemplate(PostfixTemplateProvider provider) {
        super("camelToSnake", ".snake (helloWorld → HELLO_WORLD)", "helloWorld.snake → HELLO_WORLD", provider, ConvertUtils::toSnakeCase);
    }
}