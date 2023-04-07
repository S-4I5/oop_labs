package org.example.lab2;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public final class Main {

    @SneakyThrows
    private static <T> void invokeMethodCertainAmountOfTimes(Method method, int amountOfCalls, T argument) {
        for (int i = 0; i < amountOfCalls; i++) {
            method.invoke(new ExampleClass(), argument);
        }
    }

    public static void main(String[] args) {
        ArrayList<Method> methods = Arrays.stream(ExampleClass.class.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(MyAnnotation.class))
                .collect(Collectors.toCollection(ArrayList::new));

        methods.forEach(method ->{
            int amountOfCallsInAnnotation = method.getAnnotation(MyAnnotation.class).value();
            Class<?> argumentClass = method.getParameterTypes()[0];

            method.setAccessible(true);

            if(argumentClass.equals(int.class)){
                invokeMethodCertainAmountOfTimes(method, amountOfCallsInAnnotation, 1);
            } else if (argumentClass.equals(String.class)) {
                invokeMethodCertainAmountOfTimes(method, amountOfCallsInAnnotation, "xd");
            } else if (argumentClass.equals(Boolean.class)) {
                invokeMethodCertainAmountOfTimes(method, amountOfCallsInAnnotation, false);
            }

            method.setAccessible(false);
        });
    }
}