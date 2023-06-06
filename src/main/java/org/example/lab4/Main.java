package org.example.lab4;

import javax.swing.*;
import java.io.File;

public class Main {
    private static final File DICTIONARY_FILE = new File("test.txt");
    private static final File INPUT_FILE = new File("input.txt");

    public static void main(String[] args){
        Dictionary dictionary = new Dictionary(DICTIONARY_FILE);

        String textFile = new TextReader(INPUT_FILE).getText();

        Translator translator = new Translator(dictionary);

        System.out.println(translator.translate(textFile));
    }
}
