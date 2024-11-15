package org.example.parser;

import org.example.model.CompassDirectionEnum;
import org.example.model.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionParserTest {
    private final PositionParser positionParser = new PositionParser();

    @Test
    @DisplayName("throws NumberFormatException, when non numeric x and y co ordinates are passed")
    void testNonNumericPositionCordinates() {
        assertThrows(NumberFormatException.class, () -> {
            positionParser.parsePositionString("x 2 N");
        });
    }
    @Test
    @DisplayName("throws IllegalArgumentException, when any invalid direction is passed")
    void testInvalidDirectionArgument() {
        assertThrows(IllegalArgumentException.class, () ->
            positionParser.parsePositionString("3 2 4"));
    }

    @Test
    @DisplayName("throws IllegalArgumentException, when less than required position arguments are passed")
    void testInsufficientPositionArguments() {
        assertThrows(IllegalArgumentException.class, () ->
            positionParser.parsePositionString("3 2"));
    }
    @Test
    @DisplayName("throws IllegalArgumentException, when empty/null are passed as input")
    void testEmptyStringArguments() {
        assertAll("check for empty or null input arguments for position",
                ()-> assertThrows(IllegalArgumentException.class, () ->
                        positionParser.parsePositionString(" ")),
                ()->assertThrows(IllegalArgumentException.class,()->
                        positionParser.parsePositionString("2   "))
       );
    }


    @Test
    @DisplayName("returns Position instance, when valid x, y and direction are passed as input")
    void testValidPositionArguments() {
        Position position = positionParser.parsePositionString("0 0 E");
        assertAll("check position instance",
                ()-> assertEquals(0, position.getX()),
                ()->assertEquals(0, position.getY()),
                ()->assertEquals(CompassDirectionEnum.E, position.getDirectionFacing())
        );
    }

}