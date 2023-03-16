package com.java.tasks.strings;

/**
 * Проверка, содержит ли строка только цифры
 */
public class IsStringContainOnlyNumbers {

    public static void main(String[] args) {
        String testOnlyDigits = "1234";
        String testDigitsWithCharacter = "12b34";

        System.out.println(containsOnlyDigits(testOnlyDigits));
        System.out.println(containsOnlyDigits(testDigitsWithCharacter));

        System.out.println(containsOnlyDigitsWithStreamApi(testOnlyDigits));
        System.out.println(containsOnlyDigitsWithStreamApi(testDigitsWithCharacter));

        System.out.println(containsOnlyDigitsWithRegEx(testOnlyDigits));
        System.out.println(containsOnlyDigitsWithRegEx(testDigitsWithCharacter));
    }

    private static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsOnlyDigitsWithStreamApi(String str) {
        return str.chars()
                .allMatch(Character::isDigit);
    }

    private static boolean containsOnlyDigitsWithRegEx(String str) {
        return str.matches("[0-9]+");
    }
}
