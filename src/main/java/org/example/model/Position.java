package org.example.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private CompassDirectionEnum directionFacing;

    public Position(int x, int y, CompassDirectionEnum facing) {
        this.x = x;
        this.y = y;
        this.directionFacing = facing;
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

    public CompassDirectionEnum getDirectionFacing() {
        return directionFacing;
    }
    public void setDirectionFacing(CompassDirectionEnum directionFacing) {
        this.directionFacing = directionFacing;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", facing=" + directionFacing +
                '}';
    }

    public boolean equals(Position inComingPosition) {
        if (this == inComingPosition) return true;
        if (inComingPosition == null || getClass() != inComingPosition.getClass()) return false;
        return x == inComingPosition.x && y == inComingPosition.y && directionFacing == inComingPosition.directionFacing;
    }

}
