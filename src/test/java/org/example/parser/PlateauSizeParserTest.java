package org.example.parser;

import org.example.model.PlateauSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauSizeParserTest {

    private final PlateauSizeParser plateauSizeParser = new PlateauSizeParser();
    @Test
    @DisplayName("throws NumberFormatException, when invalid input arguments are passed")
    void testNonNumberInputs() {
        assertThrows(NumberFormatException.class,()->plateauSizeParser.parsePlateauSize("eight five"));
    }
    @Test
    @DisplayName("throws IllegalArgumentException, when empty/null input arguments are passed")
    void testEmptyInputs() {
        assertThrows(IllegalArgumentException.class,()->plateauSizeParser.parsePlateauSize(null));
    }

    @Test
    @DisplayName("throws IllegalArgumentException, when less than 2 valid dimensions are passed")
    void testInsufficientInputs() {
        assertThrows(IllegalArgumentException.class,()->plateauSizeParser.parsePlateauSize("5"));
    }

    @Test
    @DisplayName("returns PlateauSize instance with length and width, when valid and sufficient arguments are passed")
    void testValidInputs() {
        PlateauSize plateauSize = plateauSizeParser.parsePlateauSize("5 5");
        assertAll("verify valid dimensions ",
                ()->assertEquals(5,plateauSize.getMaxX()),
                ()->assertEquals(5,plateauSize.getMaxY())
        );

    }



}