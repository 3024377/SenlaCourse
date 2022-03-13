package task5;

/*
Есть набор предметов, задаваемый заранее, предметы могут повторяться. Предмет имеет 2 параметра 
(обязательных, остальные добавлять на усмотрение): объем (целое значение) и ценность (целое значение). 
Предметы неделимы. Также задаётся сейф с обязательным параметром его объёма (целое значение).
Нужно написать программу, которая наполняет сейф набором предметов таким образом, 
чтобы ценность этого набора была максимальной.
 */

import java.util.Scanner;

public class Solution {

    private static final int MIN_VALUE = 1;
    private static final String CONSTRAINT_MESSAGE = "Все вводимые значения должны быть целыми и больше 0.";
    private static final String INPUT_MESSAGE = "Введите количество предметов для заполнения сейфа:";
    private static final String VAULT_VOLUME_MESSAGE = "Введите объём сейфа:";
    private static final String VOLUME_ITEM_MESSAGE = "Введите объём предмета #%d:";
    private static final String PRICE_ITEM_MESSAGE = "Введите цену предмета #%d:";
    private static final String ERROR_MESSAGE = "Введеное значение не соответствует требованиям. Повторите ввод...\n";
    private static final String RESULT_MESSAGE = "\nМаксимальная стоимость предметов, наполняющих сейф, составляет - ";
    private static final String FINAL_MESSAGE =
            """
                    \nДанное задание является разновидностью "задачи о неограниченном рюкзаке" с повторяющимися
                    предметами, оно решается при помощи уравнения Беллмана. Этот подход дает оптимальное решение,
                    но не подразумевает трассировку (перечисление) предметов.
                                        
                    Задача об ограниченном рюкзаке (0-1) позволяет выполнить трассировку при помощи динамического
                    программирования, но не допускает повторения предметов в наборе.
                    """;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Solution solution = new Solution();
            System.out.println(CONSTRAINT_MESSAGE);

            int weightLimit = solution.getInputNumber(scanner, VAULT_VOLUME_MESSAGE);
            Vault vault = new Vault(weightLimit);

            Item[] items = solution.createItemsSet(scanner);

            solution.fillVault(vault, items);

            System.out.println(RESULT_MESSAGE + vault.getBestPrice());
            System.out.println(FINAL_MESSAGE);
        }
    }

    private Integer getInputNumber(Scanner scanner, String message) {
        System.out.println(message);
        String input = scanner.next();

        try {
            int inputNumber = Integer.parseInt(input);
            return inputNumber > MIN_VALUE
                    ? inputNumber
                    : getInputNumber(scanner, message);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
            return getInputNumber(scanner, message);
        }
    }

    private void fillVault(Vault vault, Item[] items) {
        int weightLimit = vault.getVolume();
        int[] bestMatch = vault.getBestMatch();

        for (int i = 0; i <= weightLimit; i++) {
            for (Item item : items) {
                if (item.getVolume() <= i) {
                    bestMatch[i] = Math.max(bestMatch[i], bestMatch[i - item.getVolume()] + item.getPrice());
                }
            }
        }
    }

    private Item[] createItemsSet(Scanner scanner) {
        int itemCount = getInputNumber(scanner, INPUT_MESSAGE);
        Item[] items = new Item[itemCount];

        for (int i = 0; i < itemCount; i++) {
            items[i] = createItem(scanner, i + 1);
            System.out.println();
        }

        return items;
    }

    private Item createItem(Scanner scanner, int itemNumber) {
        int volume = getInputNumber(scanner, String.format(VOLUME_ITEM_MESSAGE, itemNumber));
        int price = getInputNumber(scanner, String.format(PRICE_ITEM_MESSAGE, itemNumber));
        return new Item(volume, price);
    }
}
