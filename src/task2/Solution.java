package task2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Создать программу, которая будет вычислять и выводить на экран простые множители из которых состоит целое число,
введенное пользователем. Если введено не целое число, то сообщать ему об ошибке.
 */

public class Solution {

    private static final int MIN_VALUE = 2;
    private static final String INPUT_MESSAGE = "Введите целое положительное число больше 1: ";
    private static final String ERROR_MESSAGE = "Введеное значение не соответствует требованиям. Повторите ввод...";
    private static final String SIMPLE_MULTIPLIERS_MESSAGE = "Простые множители введенного числа: \n";

    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer inputNumber = solution.getInputNumber();
        List<Integer> simpleMultipliers = solution.factorize(inputNumber);

        System.out.println(SIMPLE_MULTIPLIERS_MESSAGE + simpleMultipliers);
    }

    private Integer getInputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MESSAGE);

        try {
            int inputNumber = scanner.nextInt();

            return inputNumber >= MIN_VALUE
                    ? inputNumber
                    : getInputNumber();

        } catch (InputMismatchException e) {
            System.out.println(ERROR_MESSAGE);
            return getInputNumber();
        } finally {
            scanner.close();
        }
    }

    private List<Integer> factorize(int inputNumber) {
        List<Integer> simpleMultipliers = new ArrayList<>();

        for (int i = MIN_VALUE; i <= inputNumber; i++) {

            if (inputNumber % i == 0) {
                simpleMultipliers.add(i);
                inputNumber /= i;
                i--;
            }

        }

        return simpleMultipliers;
    }
}
