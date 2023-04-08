package com.java.tasks.sorting;

import java.util.Arrays;

/**
 * Сортировка вставками
 * Сложность: O(n^2)
 * Данная сортировка является "устойчивой". Это значит, что одинаковые элементы не изменят свой порядок.
 * Одинаковые с точки зрения характеристики, по которой мы сортируем.
 * Общая суть сортировок вставками такова:
 * - перебираются элементы в неотсортированной части массива.
 * - каждый элемент вставляется в отсортированную часть массива на то место, где он должен находиться.
 * То есть, сортировки вставками всегда делят массив на 2 части — отсортированную и неотсортированную.
 * Лучше всего подходит для обработки почти упорядоченных массивов.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] initialArray = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};

        sort(initialArray);
        System.out.println(Arrays.toString(initialArray));
    }

    private static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > currentElement) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = currentElement;
        }
    }
}
