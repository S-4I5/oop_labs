package org.example.lab4;

import java.io.File;

public class Main {
    private static final File DICTIONARY_FILE = new File("src/main/java/org/example/lab4/txts/test.txt");
    private static final File INPUT_FILE = new File("src/main/java/org/example/lab4/txts/input.txt");

    public static void main(final String[] arg){
        Dictionary dictionary = new Dictionary(DICTIONARY_FILE);

        String textFile = new TextReader(INPUT_FILE).getText();

        Translator translator = new Translator(dictionary);

        System.out.println(translator.translate(textFile));
    }
}
