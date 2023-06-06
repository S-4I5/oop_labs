package org.example.lab1.movers;

import org.example.lab1.Mover;

import javax.swing.*;

public class Horse implements Mover {

    @Override
    public void move() {
        System.out.println("Moving on horse...");
    }
}
