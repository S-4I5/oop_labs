package org.example.lab7.lab6;

import javax.swing.*;
import java.util.Random;

public class Program extends Thread{
    public final Object mutex = new Object();
    public ProgramState programState = ProgramState.UNKNOWN;
    private final JTextArea area;

    public Program(JTextArea area){
        this.area = area;
    }

    @Override
    public void run() {
        Thread daemon = new Thread(() -> {
            while(!isInterrupted()){

                synchronized (mutex) {

                    programState = setRandomState();
                    area.append(String.valueOf(programState) + "\n");
                    mutex.notify();

                }

                Wait.sleep(1000);
            }
        });

        daemon.setDaemon(true);
        daemon.start();
    }

    private ProgramState setRandomState(){
        int pick = new Random().nextInt(ProgramState.values().length);
        return ProgramState.values()[pick];
    }
}
