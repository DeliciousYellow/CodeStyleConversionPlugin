package org.delicious.plugin.template;

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import org.delicious.plugin.util.ConvertUtils;

public class ToCamelTemplate extends RenameTemplate {
    public ToCamelTemplate(PostfixTemplateProvider provider) {
        super("toCamelCase", ".camel (hello_world → helloWorld)", "hello_world.camel → helloWorld", provider, ConvertUtils::toCamelCase);
    }
}