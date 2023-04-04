package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        Scanner in = new Scanner(System.in);
        String command = "";

        while(!command.equals("exit")){
            command = in.nextLine();

            switch (command){
                case "set horse" -> hero.setMover(new Horse());
                case "set plane" -> hero.setMover(new Plane());
                case "set feet" -> hero.setMover(new Feet());
                case "move" -> hero.move();
                default -> {}
            }
        }
        
        in.close();
    }
}
