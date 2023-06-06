package org.example.lab7.lab1.movers;

import org.example.lab1.Mover;

import javax.swing.*;

public class Feet implements Mover {
    private final JTextArea area;

    public Feet(JTextArea area) {
        this.area = area;
    }

    @Override
    public void move() {
        area.append("Moving by feet...\n");
    }
}
