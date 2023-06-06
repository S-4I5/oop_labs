package org.example.lab7.lab3;

import org.example.lab3.animal_hierarchy.*;
import org.w3c.dom.Text;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Lab3 {
    private static final List<Mammal> MAMMALS = new ArrayList<>(List.of(
            new CommonHedgehog(),
            new Manul()
    ));
    private static final List<Predator> PREDATORS = new ArrayList<>(List.of(
            new Manul(),
            new Lynx()
    ));
    private static final List<Hedgehog> HEDGEHOGS = new ArrayList<>(List.of(
            new CommonHedgehog()
    ));
    private static final List<? super CommonHedgehog> firstCollection = new ArrayList<>();
    private static final List<? super Manul> secondCollection = new ArrayList<>();
    private static final List<? super Predator> thirdCollection = new ArrayList<>();

    public static <T> void printCollection(Collection<T> collection, JTextArea area){
        collection.forEach(x -> area.append(x.toString() + "\n"));
    }

    public static void segregate(Collection<? extends Mammal> scr,
                                 Collection<? super CommonHedgehog> result1,
                                 Collection<? super Manul> result2,
                                 Collection<? super Predator> result3){
        scr.forEach(animal ->{
            if(animal instanceof CommonHedgehog){
                result1.add((CommonHedgehog) animal);
            }
            if(animal instanceof Manul){
                result2.add((Manul) animal);
            }
            if(animal instanceof Lynx){
                result3.add((Lynx) animal);
            }
        });
    }

    public static void main(JTextArea text) {
        segregate(MAMMALS, firstCollection, secondCollection ,thirdCollection);
        printCollection(firstCollection, text);
        printCollection(secondCollection,text);
        printCollection(thirdCollection, text);
        segregate(PREDATORS, firstCollection, secondCollection ,thirdCollection);
        printCollection(firstCollection, text);
        printCollection(secondCollection, text);
        printCollection(thirdCollection, text);
        segregate(HEDGEHOGS, firstCollection, secondCollection, thirdCollection);
        printCollection(firstCollection, text);
        printCollection(secondCollection, text);
        printCollection(thirdCollection, text);
    }
}
