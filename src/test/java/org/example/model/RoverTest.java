package org.example.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    @Test
    void getPosition() {
    }

    @Test
    void setPosition() {
    }


    @Test
    @DisplayName("moves rover in the positive direction of Y axis, when rover is facing North")
    public void testMoveFurtherNorth() {
        Position initialPosition = new Position(1, 0, CompassDirectionEnum.N);
        Rover rover = new Rover(initialPosition);
        rover.move(List.of(InstructionEnum.M));
        Position newPosition = rover.getPosition();
        assertAll("verifying new position of the rover, only Y point should be 1 after moving",
                ()->assertEquals(1, newPosition.getX()),
                ()-> assertEquals(1, newPosition.getY()),
                ()->assertEquals(CompassDirectionEnum.N, newPosition.getDirectionFacing())
        );
    }

    @Test
    @DisplayName("moves rover in the negative direction of X axis, when rover is facing West")
    public void testMoveFurtherWest() {
        Position initialPosition = new Position(1, 2, CompassDirectionEnum.W);
        Rover rover = new Rover(initialPosition);
        Position newPosition = rover.move(List.of(InstructionEnum.M));
        assertAll("verifying new position of the rover, only Y point should be 1 after moving",
                ()->assertEquals(0, newPosition.getX()),
                ()-> assertEquals(2, newPosition.getY()),
                ()->assertEquals(CompassDirectionEnum.W, newPosition.getDirectionFacing())
        );
    }

    @Test
    @DisplayName("moves rover in the negative direction of Y axis, when rover is facing South")
    public void testMoveSouth() {
        Position initialPosition = new Position(2, 2, CompassDirectionEnum.S);
        Rover rover = new Rover(initialPosition);
        rover.move(List.of(InstructionEnum.M));  // Move South
        Position newPosition = rover.getPosition();
        assertAll("verifying new position of the rover, only Y point should be less by 1 after moving",
                ()->assertEquals(2, newPosition.getX()),
                ()-> assertEquals(1, newPosition.getY()),
                ()->assertEquals(CompassDirectionEnum.S, newPosition.getDirectionFacing())
        );
    }

    @Test
    @DisplayName("turns rover to left of North i.e West, when rover is facing North")
    public void testTurnLeftFromNorth() {
        Position initialPosition = new Position(1, 2, CompassDirectionEnum.N);
        Rover rover = new Rover(initialPosition);
        Position positionAfterTurn = rover.turn(InstructionEnum.L);

        assertAll("verifying new position of the rover, only Y point should be less by 1 after moving",
                ()->assertEquals(1, positionAfterTurn.getX()),
                ()->assertEquals(2, positionAfterTurn.getY()),
                ()->assertEquals(CompassDirectionEnum.W, positionAfterTurn.getDirectionFacing())
        );
    }
    @Test
    @DisplayName("Moves rover by 1 Y point, when rover is facing North")
    void moveToNewXYPoints() {
        Position initPos = new Position(0,0,CompassDirectionEnum.N);
        Rover rover = new Rover(initPos);
        rover.moveToNewXYPoints();
        assertEquals(1, rover.getPosition().getY());
    }
    @Test
    @DisplayName("turns rover to right of North i.e East, when rover is facing North")
    public void testTurnRightFromNorth() {
        Position initialPosition = new Position(0, 0, CompassDirectionEnum.N);
        Rover rover = new Rover(initialPosition);
        Position newPosition = rover.turn(InstructionEnum.R);
        assertEquals(0, newPosition.getX());
        assertEquals(0, newPosition.getY());
        assertEquals(CompassDirectionEnum.E, newPosition.getDirectionFacing());
    }

    @Test
    @DisplayName("turns rover to right of East i.e south, when rover is facing East")
    public void testTurnRightFromEast() {
        Position initialPosition = new Position(0, 0, CompassDirectionEnum.E);
        Rover rover = new Rover(initialPosition);
        Position newPosition = rover.turn(InstructionEnum.R);
        assertEquals(0, newPosition.getX());
        assertEquals(0, newPosition.getY());
        assertEquals(CompassDirectionEnum.S, newPosition.getDirectionFacing());
    }


    @Test
    @DisplayName("rover executes the list of instructions and returns the final position")
    public void testSetOfMove() {
        Position initialPosition = new Position(2, 2, CompassDirectionEnum.N);
        Rover rover = new Rover(initialPosition);
        //MLMR 2,3->2,3,W->1,3,W->1,4,N
        Position newPosition = rover.move(List.of(InstructionEnum.M, InstructionEnum.L, InstructionEnum.M, InstructionEnum.R));
        assertEquals(1, newPosition.getX());
        assertEquals(3, newPosition.getY());
        assertEquals(CompassDirectionEnum.N, newPosition.getDirectionFacing());
    }

    @Test
    @DisplayName("rover throws exception when the list of instructions with one Invalid instruction is passed")
    public void testSetOfMovesWithInvalidMove() {
        Position initialPosition = new Position(2, 2, CompassDirectionEnum.N);
        Rover rover = new Rover(initialPosition);
        //MLMR 2,3->2,3,W->1,3,W->1,4,N
        assertThrows(IllegalArgumentException.class,
                ()-> rover.move(List.of(InstructionEnum.M, InstructionEnum.L, InstructionEnum.M, InstructionEnum.R, InstructionEnum.valueOf("P"))));
    }

    @Test
    @DisplayName("rover throws exception when invalid turn command is passed")
    public void testInvalidTurnInstruction() {
        Position initialPosition = new Position(0, 0, CompassDirectionEnum.N);
        Rover rover = new Rover(initialPosition);
        assertThrows(IllegalArgumentException.class, () -> rover.turn(InstructionEnum.valueOf("X")));
    }

    @Test
    @DisplayName("rover throws exception when invalid move command is passed")
    public void testInvalidMoveInstruction() {
        Position initialPosition = new Position(0, 0, CompassDirectionEnum.N);
        Rover rover = new Rover(initialPosition);
        assertThrows(IllegalArgumentException.class, () -> rover.move(List.of(InstructionEnum.valueOf("P"))));
    }

    @Test
    @DisplayName("rover position does not change, when stop is called on rover")
    public void testStopDoesNotMove() {
        Position initialPosition = new Position(0, 0, CompassDirectionEnum.N);
        Rover rover = new Rover(initialPosition);
        rover.stop();
        Position newPosition = rover.getPosition();
        assertEquals(0, newPosition.getX());
        assertEquals(0, newPosition.getY());
        assertEquals(CompassDirectionEnum.N, newPosition.getDirectionFacing());
    }
}