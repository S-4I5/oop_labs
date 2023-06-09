package org.example.lab6;

import java.util.Random;

public class Program extends Thread{
    public final Object mutex = new Object();
    public ProgramState programState = ProgramState.UNKNOWN;

    @Override
    public void run() {
        Thread daemon = new Thread(() -> {
            try {
                while(!isInterrupted()){

                    synchronized (mutex) {
                        mutex.notify();

                        programState = setRandomState();
                        System.out.println(programState);

                        mutex.wait();
                    }
                    Wait.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
