package com.java.tasks.strings;

import java.util.stream.IntStream;

/**
 * Проверка, что строка является палиндромом (без учета регистра)
 */
public class PalindromeChecking {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Radar"));
        System.out.println(isPalindromeWithForCycle("Radar"));
        System.out.println(isPalindromeWithStringBuilder("Radar"));
        System.out.println(isPalindromeWithStreamApi("Radar"));
    }

    private static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindromeWithForCycle(String str) {
        str = str.toLowerCase();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeWithStringBuilder(String str) {
        str = str.toLowerCase();
        return str.equals(new StringBuilder(str)
                .reverse()
                .toString()
        );
    }

    private static boolean isPalindromeWithStreamApi(String str) {
        return IntStream
                .range(0, str.length() / 2)
                .allMatch(p -> str.toLowerCase().charAt(p) == str.toLowerCase().charAt(str.length() - p - 1));
    }
}
