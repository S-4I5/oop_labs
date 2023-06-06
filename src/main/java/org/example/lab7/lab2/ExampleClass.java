package org.example.lab7.lab2;

import javax.swing.*;

public class ExampleClass {
    public void method1(int value, JTextArea area){
        area.append(value + "\n");
    }

    @MyAnnotation(1)
    public void method2(int value, JTextArea area){
        area.append(value + "\n");
    }

    protected void method3(boolean value, JTextArea area){
        area.append(value + "\n");
    }

    @MyAnnotation(2)
    protected void method4(boolean value, JTextArea area){
        area.append(value + "\n");
    }

    private void method5(String value, JTextArea area){
        area.append(value + "\n");
    }

    @MyAnnotation(3)
    private void method6(String value, JTextArea area){
        area.append(value + "\n");
    }
}
