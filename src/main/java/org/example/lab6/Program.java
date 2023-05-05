package org.example.lab6;

import java.util.Random;

public class Program extends Thread{
    public Object mutex = new Object();
    public volatile boolean interrupted = false;
    public volatile ProgramState programState = ProgramState.UNKNOWN;

    @Override
    public void run() {
        Thread daemon = new Thread(() -> {
            while(!interrupted){
                Wait.sleep(1000);
                synchronized (mutex){
                    if(interrupted){
                        break;
                    }
                    programState = setRandomState();
                    System.out.println(programState);
                    mutex.notify();
                }
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
