package org.example.lab6;

import javax.swing.plaf.TableHeaderUI;

public class Main {
    public static void main(String[] args) {
        new Thread(new SuperVisor()).start();
    }
}
