package task3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Создайте программу, которая будет:
подсчитывать количество гласных в словах выводить слова отсортированным списком по количеству гласных
(сначала те, у которых больше гласных) делать первую гласную букву в слове заглавной
Предложение вводится пользователем вручную русскими буквами. Разделитель пробел (“ ”).
 */

public class Solution {

    private static final String INPUT_MESSAGE = "Введите с клавиатуры любые слова на русском языке :";
    private static final String NO_CYRILLIC_MESSAGE = "Введенный текст содержит не кириллические символы, попробуйте еще раз...";
    private static final String DELIMITER = " ";
    private static final String REG_EX_VOWELS = "[аеёиоуыэюяАЕЁИОУЫЭЮЯ]";
    private static final String REG_EX_CYRILLIC = "[а-яА-ЯёЁ\\d\\s\\p{Punct}]*";

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = solution.getInputString();
        solution.printWordSortedByNumberVowels(input);
    }

    private String getInputString() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(INPUT_MESSAGE);
            String inputString = scanner.nextLine();

            while (!validateCyrillic(inputString)) {
                System.out.println(NO_CYRILLIC_MESSAGE);
                inputString = scanner.nextLine();
            }

            return inputString;
        }
    }

    private boolean validateCyrillic(String input) {
        return getPatternMatcher(input, REG_EX_CYRILLIC).matches();
    }

    private void printWordSortedByNumberVowels(String input) {
        Arrays.stream(input.split(DELIMITER))
                .sorted((s1, s2) -> {
                    long numberVowelsAtS1 = calculateNumberVowels(s1);
                    long numberVowelsAtS2 = calculateNumberVowels(s2);

                    return Long.compare(numberVowelsAtS2, numberVowelsAtS1);
                })
                .map(this::firstVowelToUpperCase)
                .forEach(System.out::println);
    }

    private String firstVowelToUpperCase(String word) {
        Integer firstInputVowel = findFirstInputVowel(word);

        if (firstInputVowel != null) {
            char[] chars = word.toCharArray();
            chars[firstInputVowel] = Character.toUpperCase(chars[firstInputVowel]);
            return new String(chars);
        } else {
            return word;
        }
    }

    private Integer findFirstInputVowel(String word) {
        return getPatternMatcher(word, REG_EX_VOWELS)
                .results()
                .findFirst()
                .map(MatchResult::start)
                .orElse(null);
    }

    private long calculateNumberVowels(String word) {
        return getPatternMatcher(word, REG_EX_VOWELS)
                .results()
                .count();
    }

    private Matcher getPatternMatcher(String word, String regEx) {
        return Pattern.compile(regEx).matcher(word);
    }

}

