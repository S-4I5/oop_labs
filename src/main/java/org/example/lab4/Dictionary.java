package org.example.lab4;

import org.example.lab4.exceptions.FileReadException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dictionary {
    private final Map<String, String> wordMap;
    private BufferedReader bufferedReader;

    public Dictionary(File file) {
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
            e.printStackTrace();
        }

        wordMap = bufferedReader.lines()
                .map(new StringMapper())
                .sorted((o1, o2) -> o2[0].length() - o1[0].length())
                .collect(Collectors.toMap(
                        line -> line[0].trim(),
                        line -> line[1].trim(),
                        (x, y) -> y,
                        LinkedHashMap::new
                ));
    }

    public Map<String, String> getWords(){
        return wordMap;
    }
}
