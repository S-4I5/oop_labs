package org.example.lab6;

public class SuperVisor implements Runnable{
    private final Program program = new Program();

    @Override
    public void run() {
        try {
            program.start();

            while (!program.isInterrupted()) {

                synchronized (program.mutex){

                    program.mutex.notify();

                    switch (program.programState){
                        case STOPPING, UNKNOWN, RUNNING -> {
                            program.programState = ProgramState.RUNNING;
                            program.mutex.wait();
                        }
                        case FATAL -> program.interrupt();
                    }
                }

                Wait.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
