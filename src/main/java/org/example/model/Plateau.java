package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Plateau {
    private static Plateau plateau;
    private int maxX;
    private int maxY;
    private  final List<Rover> rovers = new ArrayList<>();
    private Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }
    //singleton to avoid modification of plateau once the mission is launched
    public static Plateau getInstance(int maxX, int maxY){
        if(plateau == null){
            plateau = new Plateau(maxX,maxY);
        }else {
            if(plateau.maxX != maxX || plateau.maxY != maxY){
                throw new RuntimeException("Plateau dimensions cannot be changed while the mission is ongoing");
            }
        }
        return plateau;
    }

    public List<Rover> getRovers(){
        return rovers;
    }
    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    @Override
    public String toString() {
        return "PlateauSize{" +
                "maxX=" + maxX +
                ", maxY=" + maxY +
                '}';
    }

    //todo: check if rover position is going out of bounds of plateau
    public boolean isWithinBoundary(Position position){
        return (position.getX() >= 0 && position.getX() <= maxX) && (position.getY() >= 0 && position.getY() <= maxY);
    }

    //todo: avoid collision by checking for position
    public boolean isOccupied(Position position){
        return rovers.stream().anyMatch(rover ->rover.getPosition().equals(position));
    }

    //todo: land a rover on one of the co ordinate
    public void addRover(Rover rover){
        if(rover == null){
            throw new IllegalArgumentException("Rover instance cannot be null");
        }
        if(isWithinBoundary(rover.getPosition()) && !isOccupied(rover.getPosition())){
            rovers.add(rover);
            System.out.println("rover landed on plateau");
        }
    }

    //todo: remove rover once deployed and completes mission?
    public void removeRoverFromPlateau(Rover rover){
        System.out.println("Recall rover from plateau. . . ");
        rovers.remove(rover);
        System.out.println("Recall complete");
    }


}
