package org.example.lab6;

public class SuperVisor implements Runnable{
    private static Program program = new Program();
    @Override
    public void run() {
        program.start();
        while (!program.interrupted) {
            synchronized (program.mutex){
                try {
                    program.mutex.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            switch (program.programState){
                case STOPPING, UNKNOWN -> program.programState = ProgramState.RUNNING;
                case FATAL -> program.interrupted = true;
            }
        }
    }
}
