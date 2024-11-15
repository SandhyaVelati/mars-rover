package org.example.model;

public class Plateau {
    private int maxX;
    private int maxY;

    public Plateau() {

    }
    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    @Override
    public String toString() {
        return "PlateauSize{" +
                "maxX=" + maxX +
                ", maxY=" + maxY +
                '}';
    }
}
