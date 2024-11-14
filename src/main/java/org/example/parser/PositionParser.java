package org.example.parser;


import org.example.model.CompassDirectionEnum;
import org.example.model.Position;

public class PositionParser {
    //sample : 1 2 N
    public Position parsePositionString(String positionInput){
        String[] positionArgs = positionInput.split(" ");
        if(positionInput.isBlank() || positionInput.isEmpty()){
            throw new IllegalArgumentException("Invalid input for position");
        }
        if(positionArgs.length != 3){
            throw new IllegalArgumentException("Incorrect number of inputs for position");
        }
        int xPoint = Integer.parseInt(positionArgs[0]);
        int yPoint = Integer.parseInt(positionArgs[1]);
        CompassDirectionEnum currentDirection = CompassDirectionEnum.valueOf(positionArgs[2]);
        return new Position(xPoint,yPoint, currentDirection);
    }
}
