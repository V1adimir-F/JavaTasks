package com.java.tasks.strings;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Удаление заданного символа
 */
public class DeletingGivenCharacter {

    public static void main(String[] args) {
        System.out.println(removeCharacter("Teast", 'a'));
        System.out.println(removeCharacterWithStringBuilder("Teast", 'a'));
        System.out.println(removeCharacterWithStreamApi("Teast", 'a'));
        System.out.println(removeCharacterForCodePoints("Teast", "a"));
    }

    private static String removeCharacter(String str, char ch) {
        return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
    }

    private static String removeCharacterWithStringBuilder(String str, char removingChar) {
        StringBuilder result = new StringBuilder();
        char[] charArray = str.toCharArray();

        for (char character : charArray) {
            if (character != removingChar) {
                result.append(character);
            }
        }

        return result.toString();
    }

    private static String removeCharacterWithStreamApi(String str, char removingChar) {
        return str.chars()
                .filter(c -> c != removingChar)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    /**
     * Если мы хотим удалить юникодовую суррогатную пару,
     * мы можем опереться на методы codePointAt() и codePoints()
     */
    public static String removeCharacterForCodePoints(String str, String removingChar) {
        int codePoint = removingChar.codePointAt(0);
        return str.codePoints()
                .filter(character -> character != codePoint)
                .mapToObj(character -> String.valueOf(Character.toChars(character)))
                .collect(Collectors.joining());
    }
}
