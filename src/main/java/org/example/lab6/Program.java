package org.example.lab6;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Program extends Thread{
    public final Object mutex = new Object();
    public ProgramState programState = ProgramState.UNKNOWN;

    @Override
    public void run() {
        Thread daemon = new Thread(() -> {
            while(!isInterrupted()){

                synchronized (mutex) {

                    programState = setRandomState();
                    System.out.println(programState);
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
