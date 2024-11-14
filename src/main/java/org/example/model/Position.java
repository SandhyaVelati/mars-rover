package org.example.model;

public class Position {
    private int x;
    private int y;
    private CompassDirectionEnum facing;

    public Position(int x, int y, CompassDirectionEnum facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CompassDirectionEnum getFacing() {
        return facing;
    }

    public void setFacing(CompassDirectionEnum facing) {
        this.facing = facing;
    }


    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", facing=" + facing +
                '}';
    }
}
