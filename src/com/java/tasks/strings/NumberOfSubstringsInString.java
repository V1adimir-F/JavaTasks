package com.java.tasks.strings;

import java.util.regex.Pattern;

/**
 * Подсчет числа появлений подстроки в строке
 */
public class NumberOfSubstringsInString {

    public static void main(String[] args) {
        String str = "testing string for test substring searching";
        String substring = "test";

        System.out.println(countSubstringsInString(str, substring));
        System.out.println(countSubstringsInStringWithSplit(str, substring));
    }

    private static int countSubstringsInString(String string, String toFind) {
        int position = 0;
        int count = 0;
        int n = toFind.length();
        while ((position = string.indexOf(toFind, position)) != -1) {
            position = position + n;
            count++;
        }
        return count;
    }

    public static int countSubstringsInStringWithSplit(String string, String toFind) {
        int result = string.split(Pattern.quote(toFind), -1).length - 1;
        return Math.max(result, 0);
    }
}
