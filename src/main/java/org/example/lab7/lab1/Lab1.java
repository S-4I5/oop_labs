package org.example.lab7.lab1;

import org.example.lab7.lab1.movers.Feet;
import org.example.lab7.lab1.movers.Horse;
import org.example.lab7.lab1.movers.Plane;

import javax.swing.*;

public class Lab1 {
    private static final String EXIT_COMMAND = "exit";
    private static final String SWITCH_TO_PLANE_COMMAND = "switch_to_plane";
    private static final String SWITCH_TO_HORSE_COMMAND = "switch_to_horse";
    private static final String SWITCH_TO_FEET_COMMAND = "switch_to_feet";
    private static final String MOVE_COMMAND = "move";
    private static final String UNKNOWN_COMMAND = "unknown_command\n";
    private static final String STOPPING_COMMAND = "Stopping\n";
    private final Hero hero;
    private final JTextArea area;
    private boolean isEnded;

    public Lab1(JTextArea area) {
        this.area = area;
        this.hero = new Hero(new Feet(area));
        this.isEnded = false;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void sendCommand(String command){
        switch (command) {
            case SWITCH_TO_HORSE_COMMAND -> hero.setMover(new Horse(area));
            case SWITCH_TO_PLANE_COMMAND -> hero.setMover(new Plane(area));
            case SWITCH_TO_FEET_COMMAND -> hero.setMover(new Feet(area));
            case MOVE_COMMAND -> hero.move();
            case EXIT_COMMAND -> {
                area.append(STOPPING_COMMAND);
                isEnded = true;
            }
            default -> area.append(UNKNOWN_COMMAND);
        }
    }
}
