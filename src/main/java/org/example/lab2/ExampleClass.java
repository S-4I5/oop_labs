package org.example.lab2;

public class ExampleClass {
    public void method1(int value){
        System.out.println(value);
    }

    @MyAnnotation(1)
    public void method2(int value){
        System.out.println(value);
    }

    protected void method3(boolean value){
        System.out.println(value);
    }

    @MyAnnotation(2)
    protected void method4(boolean value){
        System.out.println(value + ";");
    }

    private void method5(String value){
        System.out.println(value);
    }

    @MyAnnotation(3)
    private void method6(String value){
        System.out.println(value);
    }
}
