package com.java.tasks.strings;

/**
 * Найти максимальное число идущих подряд одинаковых символов в строке
 */
public class MaxConsecutiveElements {

    public static void main(String[] args) {
        String textString = "aabbbccccdddddee";
        System.out.println(getMaxConsecutiveElements(textString));
    }

    private static int getMaxConsecutiveElements(String str) {
        int result = 0;
        int currentIndex = 0;

        while (currentIndex < str.length()) {
            int nextIndex = currentIndex;
            while (nextIndex < str.length() && str.charAt(nextIndex) == str.charAt(currentIndex)) {
                nextIndex++;
            }
            result = Math.max(result, nextIndex - currentIndex);
            currentIndex = nextIndex;
        }
        return result;
    }
}
