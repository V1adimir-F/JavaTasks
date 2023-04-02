package com.java.tasks.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Сортировка пузырьком
 * Алгоритм состоит из повторяющихся проходов по сортируемому массиву.
 * За каждый проход элементы последовательно сравниваются попарно и, если порядок в паре неверный, выполняется перестановка элементов.
 * Проходы по массиву повторяются N-1 раз или до тех пор, пока на очередном проходе не окажется, что обмены больше не нужны, что означает — массив отсортирован.
 * При каждом проходе алгоритма по внутреннему циклу очередной наибольший элемент массива ставится на своё место в конце массива рядом с предыдущим «наибольшим элементом»,
 * а наименьший элемент перемещается на одну позицию к началу массива («всплывает» до нужной позиции, как пузырёк в воде — отсюда и название алгоритма).
 * Сложность: O(n^{2}).
 */
public class BubbleSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 6, 1, 4, 2, 8, 5, 9, 7));
        System.out.println(sort(list));
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> list) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    swap(list, i, i - 1);
                    needIteration = true;
                }
            }
        }
        return list;
    }

    private static void swap(ArrayList<Integer> list, int indexOne, int indexTwo) {
        int tmp = list.get(indexOne);
        list.set(indexOne, list.get(indexTwo));
        list.set(indexTwo, tmp);
    }
}
