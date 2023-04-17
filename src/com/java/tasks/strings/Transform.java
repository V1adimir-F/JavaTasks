package com.java.tasks.strings;

/**
 * Трансформирование строк
 */
public class Transform {

    public static void main(String[] args) {
        String result = "hello".transform(s -> s + " world");
        System.out.println(result);

        String test = "test "
                .transform(String::toUpperCase)
                .transform(s -> s.repeat(2))
                .transform(s -> s.replaceAll("S", "SSS"));
        System.out.println(test);
    }
}
