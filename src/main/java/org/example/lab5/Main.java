package org.example.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
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

    public static void main(String[] args) {
        System.out.println("Среднее значение списка целых чисел");
        System.out.println("Среднее значение EXAMPLE_INT_ARRAY: " + getListAverage(EXAMPLE_INT_ARRAY));

        System.out.println("Верхний регистр + _new_: ");
        System.out.println("Было:");
        EXAMPLE_STRING_ARRAY.forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("Стало:");
        getListInUpperCase(EXAMPLE_STRING_ARRAY).forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("Список квадратов уникальных элементов: ");
        System.out.println("Было:");
        EXAMPLE_INT_ARRAY.forEach(x -> System.out.print(x + " "));
        System.out.println("Стало:");
        getSquareOfUniqueElements(EXAMPLE_INT_ARRAY).forEach(x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("Поиск строк по первому символу: ");
        System.out.println("Было:");
        EXAMPLE_STRING_ARRAY.forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println("Стало:");
        getStringsWithLetterOnFirstPosition(EXAMPLE_STRING_ARRAY, 'A').forEach( x -> System.out.print(x + " "));
        System.out.println();

        System.out.println("Последний элемент или исключение: " + getLastElement(EXAMPLE_STRING_ARRAY));
        System.out.print("Пример с пустым массивом: ");
        try {
            System.out.println(getLastElement(new ArrayList<String>()));
        } catch (RuntimeException exception){
            System.out.println("Пустой массив");
        }

        System.out.println("Сумма чётных чисел: " + getSumOfEvenElements(EXAMPLE_INT_ARRAY));
        System.out.println(" Пример с пустым массивом: " + getSumOfEvenElements(new ArrayList<Integer>()));

        System.out.println("Строки в Map, гдe первый символ – ключ, оставшиеся – значение: ");
        System.out.println(listToMap(EXAMPLE_STRING_ARRAY));
    }
}
