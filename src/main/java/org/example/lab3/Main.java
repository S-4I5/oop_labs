package org.example.lab3;

import org.example.lab3.animal_hierarchy.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
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

    public static void main(String[] args) {
        segregate(MAMMALS, firstCollection, secondCollection ,thirdCollection);
        segregate(PREDATORS, firstCollection, secondCollection ,thirdCollection);
        segregate(HEDGEHOGS, firstCollection, secondCollection, thirdCollection);
    }
}
