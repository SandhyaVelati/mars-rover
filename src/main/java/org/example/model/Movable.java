package org.example.model;

import java.util.List;

public interface Movable<T extends CompassDirectionEnum,U extends InstructionEnum,V extends Plateau> {

    //todo: check if position can be made generic too

    /**
     * moves along the instructed co-ordinates
     * returns position once the turn is complete
     * plateau can be further improved to Surface to drive
     * */
    public Position move(List<U> u,V plateau);

    /**
     * turns in the direction of the instruction
     * returns position once the turn is complete
     * */
    public Position turn(U u);

    /***
     * stops the movable
     * returns position after stop
     */
    public Position stop();
}
