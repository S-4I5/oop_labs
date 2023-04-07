package org.example.lab1.movers;

import org.example.lab1.Mover;

public class Feet implements Mover {
    @Override
    public void move() {
        System.out.println("Moving by feet...");
    }
}
