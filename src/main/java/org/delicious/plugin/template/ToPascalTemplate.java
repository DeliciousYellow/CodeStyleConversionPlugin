package org.delicious.plugin.template;

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider;
import org.delicious.plugin.template.RenameTemplate;
import org.delicious.plugin.util.ConvertUtils;

public class ToPascalTemplate extends RenameTemplate {
    public ToPascalTemplate(PostfixTemplateProvider provider) {
        super("toPascalCase", ".pascal (hello_world → HelloWorld)", "hello_world.pascal → HelloWorld", provider, ConvertUtils::toPascalCase);
    }
}