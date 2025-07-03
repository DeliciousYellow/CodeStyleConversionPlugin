package org.delicious.plugin.util;

public class ConvertUtils {

    /**
     * 驼峰转蛇形（大写）
     * 例：camelCase → CAMEL_CASE
     */
    public static String toSnakeCase(String input) {
        return separateWords(input, "_").toUpperCase();
    }

    /**
     * 驼峰转连字符（小写）
     * 例：camelCase → camel-case
     */
    public static String toKebabCase(String input) {
        return separateWords(input, "-").toLowerCase();
    }

    /**
     * 蛇形/连字符等 → 小驼峰命名
     * 例：hello_world → helloWorld
     */
    public static String toCamelCase(String input) {
        String[] parts = input.split("[-_]");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].toLowerCase();
            if (i == 0) {
                result.append(part);
            } else {
                result.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1));
            }
        }

        return result.toString();
    }

    /**
     * 蛇形/连字符等 → 帕斯卡命名（首字母大写驼峰）
     * 例：hello_world → HelloWorld
     */
    public static String toPascalCase(String input) {
        String[] parts = input.split("[-_]");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            part = part.toLowerCase();
            result.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1));
        }

        return result.toString();
    }

    /**
     * 用指定分隔符将驼峰单词分隔
     */
    private static String separateWords(String input, String separator) {
        return input
                .replaceAll("(?<=[a-z0-9])(?=[A-Z])", separator)
                .replaceAll("(?<=[A-Z])(?=[A-Z][a-z])", separator);
    }
}
