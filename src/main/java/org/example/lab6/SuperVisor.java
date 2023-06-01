package org.example.lab6;

public class SuperVisor implements Runnable{
    private final Program program = new Program();
    public boolean running = true;

    @Override
    public void run() {
        try {
            program.start();

            while (!program.isInterrupted() && running) {

                synchronized (program.mutex){
                    program.mutex.wait();
                }

                switch (program.programState){
                    case STOPPING, UNKNOWN -> program.programState = ProgramState.RUNNING;
                    case FATAL -> program.interrupt();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
