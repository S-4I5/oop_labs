package org.example.lab4;

import org.example.lab4.exceptions.FileReadException;

import java.util.function.Function;

public class StringMapper implements Function<String, String[]> {
    @Override
    public String[] apply(String s) {
        String[] result = s.toLowerCase().split("[|]");
        if(result.length != 2){
            try {
                throw new FileReadException();
            } catch (FileReadException e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}