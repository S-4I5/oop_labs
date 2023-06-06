package org.example.lab7;

import org.example.lab4.exceptions.FileReadException;
import org.example.lab7.lab6.SuperVisor;
import org.example.lab7.lab1.Lab1;
import org.example.lab7.lab2.Lab2;
import org.example.lab7.lab3.Lab3;
import org.example.lab7.lab4.Lab4;
import org.example.lab7.lab5.Lab5;

import java.awt.*;

import javax.swing.*;

public class Main extends JFrame {
    private JTextArea text;
    private JTextField input;
    private Lab1 lab1;
    private SuperVisor lab6;

    public Main(String name) {
        super(name);
    }

    public void addComponentsToPane(Container panel) {
        final JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton lab1Button = new JButton("Lab 1");
        //lab1Button.setBackground(Color.BLUE);
        lab1Button.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton lab2Button = new JButton("Lab 2");
        //lab2Button.setBackground(Color.BLUE);
        lab2Button.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton lab3Button = new JButton("Lab 3");
        //lab3Button.setBackground(Color.BLUE);
        lab3Button.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton lab4Button = new JButton("Lab 4");
        //lab4Button.setBackground(Color.BLUE);
        lab4Button.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton lab5Button = new JButton("Lab 5");
        //lab5Button.setBackground(Color.BLUE);
        lab5Button.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton lab6Button = new JButton("Lab 6");
        //lab6Button.setBackground(Color.BLUE);
        lab6Button.setFont(new Font("Arial", Font.PLAIN, 30));

        JButton clearButton = new JButton("Clear");
        //clearButton.setBackground(Color.BLUE);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 30));

        jPanel.add(lab1Button);
        jPanel.add(lab2Button);
        jPanel.add(lab3Button);
        jPanel.add(lab4Button);
        jPanel.add(lab5Button);
        jPanel.add(lab6Button);
        jPanel.add(clearButton);

        lab1Button.addActionListener(x -> {
            if(lab6 != null && lab6.isAlive()){
                return;
            }
            input.setVisible(true);
            text.append("Starting lab1:\n");
            lab1 = new Lab1(text);
        });

        lab2Button.addActionListener(x -> {
            if(lab6 != null && lab6.isAlive()){
                return;
            }
            input.setVisible(false);
            text.append("Starting lab2:\n");
            Lab2.main(text);
        });

        lab3Button.addActionListener(x -> {
            if(lab6 != null && lab6.isAlive()){
                return;
            }
            input.setVisible(false);
            text.append("Starting lab3:\n");
            Lab3.main(text);
        });

        lab4Button.addActionListener(x -> {
            if(lab6 != null && lab6.isAlive()){
                return;
            }

            input.setVisible(true);

            String[] files = input.getText().split(" ");

            if(files.length != 2){
                text.append("Enter dictionary and input files!\n");
                return;
            }

            text.append("Starting lab4:\n");
            Lab4.main(text, files[0], files[1]);
        });

        lab5Button.addActionListener(x -> {
            if(lab6 != null && lab6.isAlive()){
                return;
            }
            input.setVisible(false);
            text.append("Starting lab5:\n");
            Lab5.main(text);
        });

        lab6Button.addActionListener(x -> {
            if(lab6 != null && lab6.isAlive()){
                return;
            }
            input.setVisible(false);
            text.append("Starting lab6:\n");
            lab6 = new SuperVisor(text);
            lab6.start();
        });

        clearButton.addActionListener(x -> {
            text.setText("");
        });

        input = new JTextField(40);

        input.addActionListener(x -> {
            if(lab1 != null && !lab1.isEnded()){
                lab1.sendCommand(input.getText());
                input.setText("");
            }
        });

        text = new JTextArea(20, 40);
        text.setEditable(false);
        text.setFont(new Font("Arial", Font.PLAIN, 20));

        JScrollPane scroll = new JScrollPane (text,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        panel.add(jPanel, BorderLayout.PAGE_END);

        panel.add(scroll);

        panel.add(input, BorderLayout.PAGE_START);

    }

    private static void createAndShowGUI() {
        Main frame = new Main("YAY ITS WORKING");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());
        frame.setSize(900, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}