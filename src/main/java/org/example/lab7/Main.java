package org.example.lab7;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.*;

public class Main extends JFrame {

    private JTextArea text;
    private JTextField input;


    public Main(String name) {
        super(name);
    }


    public void addComponentsToPane(final Container pane) {
        final JPanel compsToExperiment = new JPanel(new FlowLayout(FlowLayout.LEADING));

        JButton first = new JButton("Lab 1");
        first.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton second = new JButton("Lab 2");
        second.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton third = new JButton("Lab 3");
        third.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton forth = new JButton("Lab 4");
        forth.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton fifth = new JButton("Lab 5");
        fifth.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton six = new JButton("Lab 6");
        six.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.PLAIN, 30));


        compsToExperiment.add(first);
        compsToExperiment.add(second);
        compsToExperiment.add(third);
        compsToExperiment.add(forth);
        compsToExperiment.add(fifth);
        compsToExperiment.add(six);
        compsToExperiment.add(clear);

        first.addActionListener(x -> {
            InputStream inputStream = new ByteArrayInputStream(input.getText().getBytes(StandardCharsets.UTF_8));
            System.setIn(inputStream);

            input.setText("");

            new Thread(() -> org.example.lab1.Main.main(new String[]{""})).start();
        });
        second.addActionListener(x -> {
            org.example.lab2.Main.main(new String[]{""});
        });
        third.addActionListener(x -> {
            org.example.lab3.Main.main(new String[]{""});
        });
        forth.addActionListener(x -> {
            org.example.lab4.Main.main(new String[]{""});
        });
        fifth.addActionListener(x -> {
            org.example.lab5.Main.main(new String[]{""});
        });
        six.addActionListener(x -> {
            org.example.lab6.Main.main(new String[]{""});
        });
        clear.addActionListener(x -> {
            text.setText("");
        });

        input = new JTextField(40);

        text = new JTextArea(20, 40);
        text.setEditable(false);
        text.setFont(new Font("Arial", Font.PLAIN, 20));

        JScrollPane scroll = new JScrollPane (text,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        PrintStream stream = new PrintStream(System.out) {
            public void print(String texts) {
                text.append(texts + "\n");
            }
        };

        System.setOut(stream);

        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(scroll);
        pane.add(input, BorderLayout.SOUTH);
    }

    private static void createAndShowGUI() {
        Main frame = new Main("FlowLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());
        frame.setSize(900, 500);
        frame.setVisible(true);
        //frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}