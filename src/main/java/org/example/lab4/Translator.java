package org.example.lab4;

import java.util.Map;

public class Translator {
    private final Dictionary dictionary;

    public Translator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String translate(String input){
        String result = input.trim().toLowerCase();

        for (Map.Entry<String, String> entry : dictionary.getWords().entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
