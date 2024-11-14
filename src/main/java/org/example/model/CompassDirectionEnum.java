package org.example.model;

public enum CompassDirectionEnum {
    N,
    E,
    S,
    W;

    public static String validateDirection(char directionFacing){
        return switch (directionFacing) {
            case 'N' -> "North";
            case 'S' -> "South";
            case 'W' -> "West";
            case 'E' -> "East";
            default -> throw new IllegalArgumentException("invalid value for direction" + directionFacing);
        };
    }


}
