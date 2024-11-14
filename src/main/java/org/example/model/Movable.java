package org.example.model;

public interface Movable<T extends CompassDirectionEnum,U extends InstructionEnum> {

    //todo: check if position can be made generic too

    /**
     * moves along the instructed co-ordinates
     * returns position once the turn is complete
     * */
    public Position move(U u);

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
