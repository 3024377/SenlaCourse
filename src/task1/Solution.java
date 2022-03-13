package task1;

import java.util.Scanner;

/*
Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
Если цифр нет, то возвращаемая сумма должна быть равна 0.
*/

public class Solution {

    private static final String INPUT_MESSAGE = "Введите строку для посдчета суммы содержащихся в ней цифр...";
    private static final String RESULT_MESSAGE = "Сумма введеных чисел: ";

    public static void main(String[] args) {
        int sum = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(INPUT_MESSAGE);

            String inputString = scanner.nextLine();
            char[] chars = inputString.toCharArray();

            for (char ch : chars) {
                if (Character.isDigit(ch)) {
                    sum += Integer.parseInt(String.valueOf(ch));
                }
            }

        }

        System.out.println(RESULT_MESSAGE + sum);
    }

}
