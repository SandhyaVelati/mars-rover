package org.example.model;

public enum CompassDirectionEnum {
    N,
    E,
    S,
    W;

    //rotate clockwise
    public CompassDirectionEnum turnRight() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
            default -> throw new RuntimeException("Invalid instruction to turn");
        };
    }

    //rotate antiClockwise
    public CompassDirectionEnum turnLeft() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
            default -> throw new RuntimeException("Invalid instruction to turn");
        };
    }





}
