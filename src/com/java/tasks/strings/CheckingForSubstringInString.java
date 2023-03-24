package com.java.tasks.strings;

import java.util.regex.Pattern;

/**
 * Проверка наличия подстроки в строке
 */
public class CheckingForSubstringInString {

    public static void main(String[] args) {
        String someText = "some testing text";
        String subString = "test";

        System.out.println(isContains(someText, subString));
        System.out.println(isContainsWithRegEx(someText, subString));
    }

    private static boolean isContains(String text, String subString) {
        return text.contains(subString);
    }

    private static boolean isContainsWithRegEx(String text, String subString) {
        return text.matches("(?i).*" + Pattern.quote(subString) + ".*");
    }
}
