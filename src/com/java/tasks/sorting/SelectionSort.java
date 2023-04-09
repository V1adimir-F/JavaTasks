package com.java.tasks.sorting;

import java.util.Arrays;

/**
 * Сортировка выбором
 * На массиве из n элементов имеет время выполнения в худшем, среднем и лучшем случае O(n2), предполагая что сравнения делаются за постоянное время.
 * Шаги алгоритма:
 * - находим номер минимального значения в текущем списке
 * - производим обмен этого значения со значением первой неотсортированной позиции (обмен не нужен, если минимальный элемент уже находится на данной позиции)
 * - теперь сортируем хвост списка, исключив из рассмотрения уже отсортированные элементы
 * Затраты памяти: O(1)
 * Сложность: O(n * n)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] initialArray = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};

        sort(initialArray);
        System.out.println(Arrays.toString(initialArray));
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexOfMinElement = min(array, i);

            int tmp = array[i];
            array[i] = array[indexOfMinElement];
            array[indexOfMinElement] = tmp;
        }
    }

    private static int min(int[] array, int fromIndex) {
        int minIndex = fromIndex;
        int minValue = array[fromIndex];
        for (int i = fromIndex + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
