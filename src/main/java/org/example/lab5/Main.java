package org.example.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final ArrayList<Integer> EXAMPLE_INT_ARRAY = new ArrayList<>(List.of(1,2,3,4,5));
    private static final ArrayList<String> EXAMPLE_STRING_ARRAY = new ArrayList<>(List.of(
            "Amogus",
            "SYS",
            "XDDDD"));

    public double getListAverage(ArrayList<Integer> list){
        return list.stream().mapToInt(x -> x)
                .average().orElse(0);
    }

    public ArrayList<String> getListInUpperCase(ArrayList<String> list){
        return list.stream().map(x -> x.toUpperCase().concat("_new_"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /*public ArrayList<Integer> getSquareOfUniqueElements(ArrayList<Integer> list){
        return list.stream().filter(x -> list.
    }*/


    public static void main(String[] args) {

    }
}
