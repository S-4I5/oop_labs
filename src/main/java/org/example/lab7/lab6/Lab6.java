package org.example.lab7.lab6;

import javax.swing.*;

public class Lab6 {
    public static void main(JTextArea area) {

        new Thread(new SuperVisor(area)).start();
    }
}
