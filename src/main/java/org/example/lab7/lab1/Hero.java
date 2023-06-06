package org.example.lab7.lab1;

import org.example.lab1.Mover;

public class Hero {
    private Mover mover;

    public Hero(Mover mover){
        this.mover = mover;
    }

    public Mover getMover() {
        return mover;
    }

    public void setMover(Mover mover) {
        this.mover = mover;
    }

    public void move() {
        mover.move();
    }
}
