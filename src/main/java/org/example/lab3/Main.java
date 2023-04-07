package org.example.lab3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {


    public static <T extends Mammal, B extends Mammal, S extends Mammal, M extends Mammal>
    void segregate(Collection<T> scr,
                                 Collection<B> result1,
                                 Collection<S> result2,
                                 Collection<M> result3){
    }

    public static void main(String[] args) {
        Collection<Mammal> mammals = List.of(new Mammal[]{new Manul(), new Lynx(), new CommonHedgehog()});
        Collection<CommonHedgehog> commonHedgehogs = new ArrayList<>();
        Collection<Lynx> lynxes = new ArrayList<>();
        Collection<Manul> manuls = new ArrayList<>();

        segregate(mammals, commonHedgehogs, lynxes, manuls);
        System.out.printf(commonHedgehogs.size() + " " + lynxes.size() + " " + manuls.size());
    }
}
