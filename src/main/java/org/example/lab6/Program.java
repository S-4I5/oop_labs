package org.example.lab6;

public class Program implements Runnable{
    public boolean interrupted = false;
    public ProgramState programState = ProgramState.UNKNOWN;

    @Override
    public void run() {
        Thread daemon = new Thread(() -> {
            while(!interrupted){
                Wait.sleep(10000);
            }
        });
        daemon.setDaemon(true);
        daemon.start();
    }
}
