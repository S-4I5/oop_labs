package org.example.lab7.lab6;

import javax.swing.*;

public class SuperVisor extends Thread{
    private final Program program;
    public boolean running = true;

    public SuperVisor(JTextArea area) {
        this.program = new Program(area);
    }

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
                    case FATAL -> {
                        program.interrupt();
                        interrupt();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
