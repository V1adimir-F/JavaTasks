package com.java.tasks.numbers;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Вычисление факториала с помощью Stream API
 */
public class Factorial {

    private static final int VALUE = 10_000;

    public static void main(String[] args) {
        System.out.println(naive(VALUE));
        System.out.println(streamed(VALUE));
        System.out.println(streamedParallel(VALUE));
    }

    private static BigInteger naive(int n) {
        long start = System.currentTimeMillis();

        BigInteger number = BigInteger.valueOf(1);
        for (int i = 2; i <= n; ++i) {
            number = number.multiply(BigInteger.valueOf(i));
        }

        long finish = System.currentTimeMillis() - start;
        System.out.println("Время работы метода naive(): " + finish);

        return number;
    }

    private static BigInteger streamed(int n) {
        long start = System.currentTimeMillis();

        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        BigInteger result = IntStream
                .rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();

        long finish = System.currentTimeMillis() - start;
        System.out.println("Время работы метода streamed(): " + finish);

        return result;
    }

    public static BigInteger streamedParallel(int n) {
        long start = System.currentTimeMillis();

        if (n < 2) {
            return BigInteger.valueOf(1);
        }
        BigInteger result = IntStream
                .rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();

        long finish = System.currentTimeMillis() - start;
        System.out.println("Время работы метода streamedParallel(): " + finish);

        return result;
    }
}
