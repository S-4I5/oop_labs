package org.example.lab6;

public class Main {
    public static void main(String[] args) {
        new Thread(new SuperVisor()).start();
    }
}
