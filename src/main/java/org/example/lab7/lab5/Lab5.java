package org.example.lab7.lab5;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lab5 {
    private static final ArrayList<Integer> EXAMPLE_INT_ARRAY = new ArrayList<>(
            List.of( 1, 2, 2, 3, 4, 5)
    );
    private static final ArrayList<String> EXAMPLE_STRING_ARRAY = new ArrayList<>(
            List.of("Amogus", "Aaogus", "SYS", "XDDDD")
    );

    public static double getListAverage(ArrayList<Integer> list){
        return list.stream().mapToInt(x -> x)
                .average().orElse(0);
    }

    public static ArrayList<String> getListInUpperCase(ArrayList<String> list){
        return list.stream().map(x -> x.toUpperCase().concat("_new_"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Integer> getSquareOfUniqueElements(ArrayList<Integer> list){
        return list.stream()
                .filter(x -> Collections.frequency(list, x) == 1)
                .map(x -> x*x)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<String> getStringsWithLetterOnFirstPosition(ArrayList<String> list, char element){
        return list.stream()
                .filter(x -> x.charAt(0) == element)
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static <T> T getLastElement(ArrayList<T> list){
        return list.stream()
                .reduce((x,y) -> y)
                .orElseThrow(RuntimeException::new);
    }

    public static int getSumOfEvenElements(ArrayList<Integer> list){
        return list.stream()
                .mapToInt(x -> x).filter(x -> x%2 == 0)
                .sum();
    }

    public static Map<Character, String> listToMap(ArrayList<String> list){
        return list.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toMap(
                        x -> x.charAt(0),
                        x -> x,
                        (o1, o2) -> o1 + " " + o2));
    }

    public static void main(JTextArea area) {
        area.append("Среднее значение списка целых чисел\n");
        area.append("Среднее значение EXAMPLE_INT_ARRAY: " + getListAverage(EXAMPLE_INT_ARRAY) + "\n");

        area.append("Верхний регистр + _new_: \n");
        area.append("Было: \n");
        EXAMPLE_STRING_ARRAY.forEach(x -> System.out.print(x + " "));
        area.append("\n");
        area.append("Стало:\n");
        getListInUpperCase(EXAMPLE_STRING_ARRAY).forEach(x -> System.out.print(x + " "));
        area.append("\n");

        area.append("Список квадратов уникальных элементов: \n");
        area.append("Было:\n");
        EXAMPLE_INT_ARRAY.forEach(x -> area.append(x + " "));
        area.append("Стало:\n");
        getSquareOfUniqueElements(EXAMPLE_INT_ARRAY).forEach(x -> area.append(x + " "));
        area.append("\n");

        area.append("Поиск строк по первому символу: \n");
        area.append("Было:\n");
        EXAMPLE_STRING_ARRAY.forEach(x -> area.append(x + " "));
        area.append("\n");
        area.append("Стало:\n");
        getStringsWithLetterOnFirstPosition(EXAMPLE_STRING_ARRAY, 'A').forEach( x -> System.out.print(x + " "));
        area.append("\n");

        area.append("Последний элемент или исключение: " + getLastElement(EXAMPLE_STRING_ARRAY) + "\n");
        area.append("Пример с пустым массивом: \n");
        try {
            area.append(getLastElement(new ArrayList<String>()) + "\n");
        } catch (RuntimeException exception){
            area.append("Пустой массив\n");
        }

        area.append("Сумма чётных чисел: " + getSumOfEvenElements(EXAMPLE_INT_ARRAY) + "\n");
        area.append(" Пример с пустым массивом: " + getSumOfEvenElements(new ArrayList<Integer>()) + "\n");

        area.append("Строки в Map, гдe первый символ – ключ, оставшиеся – значение: \n");
        area.append(listToMap(EXAMPLE_STRING_ARRAY) + "\n");
    }
}
