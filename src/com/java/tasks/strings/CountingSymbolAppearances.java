package com.java.tasks.strings;

/**
 * Подсчет появлений некоторого символа в строке
 */
public class CountingSymbolAppearances {

    public static void main(String[] args) {
        String testString = "aaabccbeeeb";

        System.out.println(countOccurrencesOfACertainCharacter(testString, 'b'));
        System.out.println(countOccurrencesOfACertainCharacterForUnicodeSurrogatePairs(testString, "b"));
        System.out.println(countOccurrencesOfACertainCharacterByIterating(testString, 'b'));
        System.out.println(countOccurrencesOfACertainCharacterWithStreamApi(testString, 'b'));
    }

    private static int countOccurrencesOfACertainCharacter(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    private static int countOccurrencesOfACertainCharacterForUnicodeSurrogatePairs(String str, String ch) {
        if (ch.codePointCount(0, ch.length()) > 1) {
            // в заданном значении типа String более одного юникодового символа
            return -1;
        }

        int result = str.length() - str.replace(ch, "").length();

        // если ch.length() возвращает 2, то это является юникодовой суррогатной парой
        return ch.length() == 2 ? result / 2 : result;
    }

    private static int countOccurrencesOfACertainCharacterByIterating(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    private static long countOccurrencesOfACertainCharacterWithStreamApi(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
