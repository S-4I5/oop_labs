package org.example.lab4;

import org.example.lab4.exceptions.FileReadException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class TextReader {
    private final String text;
    private BufferedReader bufferedReader;

    public TextReader(File file) {
        if(!file.exists()){
            try {
                throw new FileReadException();
            } catch (FileReadException e2) {
                e2.printStackTrace();
            }
        }

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();;
        }

        text = bufferedReader.lines().collect(Collectors.joining());
    }

    public String getText() {
        return text;
    }
}
