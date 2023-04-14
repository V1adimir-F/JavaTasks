package com.java.tasks.knapsack_problem;

import java.util.ArrayList;

/**
 * Решение задачи о рюкзаке методом динамического программирования
 * Сложность O(n * w), где n - кол-во предметов, w - размер рюкзака
 */
public class Dynamic {

    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int count = weights.length;
        int maxWeight = 13;

        int[][] matrix = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            matrix[i] = new int[maxWeight + 1];
        }

        // k - размер набора предметов
        for (int k = 0; k <= count; k++) {
            // s - размер рюкзака
            for (int s = 0; s <= maxWeight; s++) {
                if (k == 0 || s == 0) {
                    matrix[k][s] = 0;
                } else {
                    // если текущий размер рюкзака >= размеру текущего предмета
                    if (s >= weights[k - 1]) {
                        matrix[k][s] = Math.max(matrix[k - 1][s], matrix[k - 1][s - weights[k - 1]] + prices[k - 1]);
                    } else {
                        matrix[k][s] = matrix[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(matrix, weights, count, maxWeight, result);

        System.out.println("Оптимальное содержимое рюкзака:");
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void traceResult(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k - 1][s] == A[k][s]) {
            traceResult(A, weight, k - 1, s, result);
        } else {
            traceResult(A, weight, k - 1, s - weight[k - 1], result);
            result.add(0, k);
        }
    }
}
