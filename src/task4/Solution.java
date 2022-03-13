package task4;

import java.util.*;

/*
Создайте программу, которая будет получать число и печатать его в следующем формате (формы цифр можно придумать свои,
главное, чтобы они читались на экране):(*).
Дополнительно: сделайте так, чтобы наибольшая цифра состояла не из ‘*’, а из соответствующих маленьких (обычных) цифр.
 */

public class Solution {

    private static final String INPUT_NUMBERS_MESSAGE = "Введите любое положительное целое число:";
    private static final String INCORRECT_INPUT_MESSAGE = "Введённые данные не соответствуют запросу. Повторите ввод...";
    private static final String DELIMITER = "  ";

    public static void main(String[] args) {
        Solution solution = new Solution();
        PaletteNumbers paletteNumbers = new PaletteNumbers();

        List<Integer> digits = solution.getInputNumber();
        int maxDigit = solution.getMaxDigit(digits);

        paletteNumbers.replaceStarToSymbol(maxDigit);

        List<MatrixSymbol> matrixSymbols = solution.getMatrixSymbolFromPalette(paletteNumbers, digits);
        List<String> result = solution.concatSymbols(matrixSymbols);

        result.forEach(System.out::println);
    }

    private List<String> concatSymbols(List<MatrixSymbol> matrixSymbols) {
        List<List<String>> lineSymbols = convertListMatrixSymbolToListLineSymbol(matrixSymbols);
        List<String> result = new ArrayList<>();

        for (int line = 0; line < PaletteNumbers.HEIGHT; line++) {
            List<String> concatLines = new ArrayList<>();

            for (List<String> lineSymbol : lineSymbols) {
                concatLines.add(lineSymbol.get(line));
            }

            String resultLine = String.join(DELIMITER, concatLines);
            result.add(resultLine);
        }

        return result;
    }

    private List<List<String>> convertListMatrixSymbolToListLineSymbol(List<MatrixSymbol> matrixSymbols) {
        return matrixSymbols.stream()
                .map(MatrixSymbol::toStringLine)
                .toList();
    }

    private List<MatrixSymbol> getMatrixSymbolFromPalette(PaletteNumbers paletteNumbers, List<Integer> digits) {
        return digits.stream()
                .map(paletteNumbers::getMatrixBySymbol)
                .toList();
    }

    private int getMaxDigit(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .max(Comparator.comparingInt(x -> x)).get();
    }

    private List<Integer> getInputNumber() {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(INPUT_NUMBERS_MESSAGE);

            String input = scanner.nextLine();
            char[] chars = input.toCharArray();

            List<Integer> digits = new ArrayList<>();

            for (char ch : chars) {
                if (!Character.isDigit(ch)) {
                    System.out.println(INCORRECT_INPUT_MESSAGE);
                    return getInputNumber();
                } else {
                    digits.add(Integer.parseInt(String.valueOf(ch)));
                }
            }

            return digits;
        }

    }

}
