package com.java.tasks.numbers;

import java.util.function.BinaryOperator;

/**
 * Сложение двух крупных чисел.
 * Помимо методов addExact(), класс Math имеет методы multiplyExact(), subtractExact() и negateExact().
 */
public class AdditionTwoBigNumbers {

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        BinaryOperator<Integer> operator = Math::addExact;
        try {
            int z = operator.apply(x, y);
        } catch (ArithmeticException e) {
            System.out.println("integer overflow");
        }
    }
}
