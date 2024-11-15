package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {
    private Plateau singleTonPlateau;
    @BeforeEach
    void setUp(){
        singleTonPlateau= Plateau.getInstance(5,5);
    }

    @Test
    void getSingleInstanceTest() {
        Plateau plateau = Plateau.getInstance(5,5);
        assertEquals(singleTonPlateau,plateau);
    }
    @Test
    void changeDimensionsInSingletonCheckTest(){
        assertThrows(RuntimeException.class,()->Plateau.getInstance(6, 5));
    }
    @Test
    void getAllRoversOnThePlateauTest() {
        Rover rover1 = new Rover(new Position(1, 2, CompassDirectionEnum.N));
        Rover rover2 = new Rover(new Position(3, 2, CompassDirectionEnum.E));
        singleTonPlateau.addRover(rover1);
        singleTonPlateau.addRover(rover2);
        List<Rover> rovers = singleTonPlateau.getRovers();
        assertAll("check rover ids",
        ()-> assertTrue(rovers.contains(rover1)),
                ()->assertTrue(rovers.contains(rover2)));
    }
    @Test
    void isWithinBoundaryTest() {
        assertTrue(singleTonPlateau.isWithinBoundary(new Position(0, 0, CompassDirectionEnum.N)));
        assertFalse(singleTonPlateau.isWithinBoundary(new Position(1, -9, CompassDirectionEnum.E)));
        assertFalse(singleTonPlateau.isWithinBoundary(new Position(7, 7, CompassDirectionEnum.N)));
        assertTrue(singleTonPlateau.isWithinBoundary(new Position(5, 5, CompassDirectionEnum.N)));
    }
    @Test
    void outOfBoundaryNoRoverToBeAddedTest() {
        Rover rover = new Rover(new Position(1, -9, CompassDirectionEnum.E));
        singleTonPlateau.addRover(rover);
        assertFalse(singleTonPlateau.getRovers().contains(rover));
    }

    @Test
    void isOccupiedTest() {
        Rover rover3 = new Rover(new Position(3, 4, CompassDirectionEnum.S));
        Rover conflictingPositionRover = new Rover(new Position(3, 4, CompassDirectionEnum.S));
        Rover nonConflictingPos = new Rover(new Position(0, 0, CompassDirectionEnum.S));
        singleTonPlateau.addRover(rover3);
        assertTrue(singleTonPlateau.isOccupied(conflictingPositionRover.getPosition()));
        assertFalse(singleTonPlateau.isOccupied(nonConflictingPos.getPosition()));
    }

    @Test
    void addRoverTest(){
        Rover rover4 = new Rover(new Position(3, 5, CompassDirectionEnum.S));
        singleTonPlateau.addRover(rover4);
        List<Rover> rovers = singleTonPlateau.getRovers();
        assertTrue(rovers.contains(rover4));
        assertThrows(IllegalArgumentException.class,()->singleTonPlateau.addRover(null));
    }

    @Test
    void removeRoverFromPlateau() {
        Rover rover = new Rover(new Position(3, 3, CompassDirectionEnum.W));
        singleTonPlateau.addRover(rover);
        assertTrue(singleTonPlateau.getRovers().contains(rover));
        singleTonPlateau.removeRoverFromPlateau(rover);
        assertFalse(singleTonPlateau.getRovers().contains(rover));
    }
    @Test
    void removeNonExistentRoverFromPlateau() {
        Rover rover5 = new Rover(new Position(3, 1, CompassDirectionEnum.W));
        singleTonPlateau.removeRoverFromPlateau(rover5);
        assertFalse(singleTonPlateau.getRovers().contains(rover5));
    }
}