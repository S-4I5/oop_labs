package org.example;

public class Hero {
    private Mover mover;

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
