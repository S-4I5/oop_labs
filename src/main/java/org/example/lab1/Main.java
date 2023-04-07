package org.example.lab1;

import org.example.lab1.movers.Feet;
import org.example.lab1.movers.Horse;
import org.example.lab1.movers.Plane;

import java.util.Scanner;

public class Main {

    private static final String EXIT_COMMAND = "exit";
    private static final String SWITCH_TO_PLANE_COMMAND = "switch to plane";
    private static final String SWITCH_TO_HORSE_COMMAND = "switch to horse";
    private static final String SWITCH_TO_FEET_COMMAND = "switch to feet";
    private static final String MOVE_COMMAND = "move";
    private static final String UNKNOWN_COMMAND = "unknown command";

    public static void main(String[] args) {
        Hero hero = new Hero(new Feet());
        Scanner in = new Scanner(System.in);
        String command = "";

        while(!command.equals(EXIT_COMMAND)){
            command = in.nextLine();

            switch (command){
                case SWITCH_TO_HORSE_COMMAND -> hero.setMover(new Horse());
                case SWITCH_TO_PLANE_COMMAND -> hero.setMover(new Plane());
                case SWITCH_TO_FEET_COMMAND -> hero.setMover(new Feet());
                case MOVE_COMMAND -> hero.move();
                default -> System.out.println(UNKNOWN_COMMAND);
            }
        }
        
        in.close();
    }
}
