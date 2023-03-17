package com.java.tasks.strings;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Удаление повторяющихся символов
 */
public class RemovingDuplicateCharacters {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("madam"));
        System.out.println(removeDuplicatesWithStreamApi("madam"));
    }

    private static String removeDuplicates(String str) {
        StringBuilder uniqueCharacters = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (uniqueCharacters.indexOf(String.valueOf(ch)) == -1) {
                uniqueCharacters.append(ch);
            }
        }
        return uniqueCharacters.toString();
    }

    public static String removeDuplicatesWithStreamApi(String str) {
        return Stream.of(str.split(""))
                .distinct ()
                .collect(Collectors.joining());
    }
}
