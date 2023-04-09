package com.java.tasks.sorting;

import java.util.Arrays;

/**
 * Сортировка подсчетом.
 * Подходит только для чисел.
 * Алгоритм сортировки, в котором используется диапазон чисел сортируемого массива (списка) для подсчёта совпадающих элементов.
 * Применение сортировки подсчётом целесообразно лишь тогда, когда сортируемые числа имеют (или их можно отобразить в) диапазон возможных значений,
 * который достаточно мал по сравнению с сортируемым множеством, например, миллион натуральных чисел меньших 1000.
 * Сложность O(n)
 */
public class CountSort {

    private static final int RANGE = 99;

    public static void main(String[] args) {
        int[] initialArray = new int[30];

        fillInitialArray(initialArray);
        System.out.println("Before: " + Arrays.toString(initialArray));

        sort(initialArray);
        System.out.println("After: " + Arrays.toString(initialArray));
    }

    private static void fillInitialArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * RANGE);
        }
    }

    private static void sort(int[] array) {
        int[] counterArray = new int[RANGE + 1];

        for (int k : array) {
            counterArray[k] += 1;
        }

        int arrayIndex = 0;
        for (int i = 0; i < counterArray.length; i++) {
            for (int j = 0; j < counterArray[i]; j++) {
                array[arrayIndex] = i;
                arrayIndex++;
            }
        }
    }
}
