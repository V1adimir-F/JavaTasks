package com.java.tasks.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Подсчет повторяющихся символов
 */
public class CountingRepeatedCharacters {

    public static void main(String[] args) {
        String characters = "aabbbccccdeefffg";

        Map<Character, Integer> resultOne = countDuplicateCharacters(characters);
        System.out.println(resultOne);

        Map<Character, Long> resultTwo = countDuplicateCharactersWithStream(characters);
        System.out.println(resultTwo);

        Map<String, Integer> resultThree = countDuplicateCharactersForUnicode(characters);
        System.out.println(resultThree);

        Map<String, Long> resultFour = countDuplicateCharactersForUnicodeWithStream(characters);
        System.out.println(resultFour);
    }

    private static Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> result = new HashMap<>();

        for (char ch: str.toCharArray()) {
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    private static Map<Character, Long> countDuplicateCharactersWithStream(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    private static Map<String, Integer> countDuplicateCharactersForUnicode(String str) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(Character.toChars(str.codePointAt(i)));
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                i++;
            }
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    private static Map<String, Long> countDuplicateCharactersForUnicodeWithStream(String str) {
        return str.codePoints()
                .mapToObj (c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
