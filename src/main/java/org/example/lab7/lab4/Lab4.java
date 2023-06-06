package org.example.lab7.lab4;

import org.example.lab4.Dictionary;
import org.example.lab4.TextReader;
import org.example.lab4.Translator;

import javax.swing.*;
import java.io.File;

public class Lab4 {
    public static void main(JTextArea area, String inputFile, String dictionaryFile){
        Dictionary dictionary = new Dictionary(new File(dictionaryFile));

        String textFile = new TextReader(new File(inputFile)).getText();

        Translator translator = new Translator(dictionary);

        area.append(translator.translate(textFile));
    }
}
