package com.java.tasks.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * На стол в ряд выложены карточки, на каждой карточке написано натуральное число.
 * За один ход разрешается взять карточку либо с левого, либо с правого конца ряда.
 * Всего можно сделать k ходов.
 * Итоговый счет равен сумме чисел на выбранных карточках.
 * Определите, какой максимальный счет можно получить по итогам игры.
 * В первой строке записано число карточек n (1 ≤ n≤ 10 в степени 5).
 * Во второй строке записано число ходов k (1 ≤ k ≤ n).
 * В третьей строке через пробел даны числа, записанные на карточках. i-е по счету число записано на i-й слева карточке.
 * Все числа натуральные и не превосходят 10 в степени 4.
 *
 * Выведите единственное число - максимальную сумму очков, которую можно набрать, сделав k ходов.
 */
public class CardCounter {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            int k = readInt(reader);
            List<Long> cards = readList(reader);

            System.out.println(getCardCount(n, k, cards));
        }
    }

    private static long getCardCount(int n, int k, List<Long> cards) {
        long result = 0;
        int count = k;

        while ((count + 1) > 0) {
            long temp = 0;
            int shift = n - count;
            for (int i = 0; i < k; i++) {
                int index = i + shift;
                if (index >= n) {
                    index = index - n;
                }
                temp += cards.get(index);
            }
            result = Math.max(result, temp);
            count--;
        }

        return result;
    }

    private static List<Long> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().strip().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }
}
