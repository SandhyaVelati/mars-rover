package org.example.parser;

import org.example.model.InstructionEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {
    private final InstructionParser instructionParser = new InstructionParser();
    @Test
    @DisplayName("throws IllegalArgumentException, when any instruction other than LRM are passed as input")
    void testInvalidInstructions() {
        assertThrows(IllegalArgumentException.class,()->instructionParser.parseInstructions("LRMU"));
    }
    @Test
    @DisplayName("throws IllegalArgumentException, when no instructions or empty instructions are passed")
    void testEmptyInstruction() {
        assertAll("check for empty or null instructions behaviour",
                ()-> assertThrows(IllegalArgumentException.class,()->instructionParser.parseInstructions("")),
                ()-> assertThrows(IllegalArgumentException.class,()->instructionParser.parseInstructions(null)),
                ()-> assertThrows(IllegalArgumentException.class,()->instructionParser.parseInstructions("  ")));
    }
    @Test
    @DisplayName("returns equal number of as List of InstructionEnum, when supplied valid number of arguments")
    void testNumberOfInstructionsParsed() {
        List<InstructionEnum> lmlmllrm = instructionParser.parseInstructions("LMLMLLRM");
        assertEquals(8, lmlmllrm.size());
    }

    @Test
    @DisplayName("returns equal number of as List of InstructionEnum, when supplied valid number of arguments")
    void testValidInstructions() {
        List<InstructionEnum> parseInstructions = instructionParser.parseInstructions("LMLMR");
        assertAll("check each instruction parsed Successfully",
                ()-> assertEquals(InstructionEnum.L,parseInstructions.get(0)),
                ()-> assertEquals(InstructionEnum.M,parseInstructions.get(1)),
                ()-> assertEquals(InstructionEnum.L,parseInstructions.get(2)),
                ()-> assertEquals(InstructionEnum.M,parseInstructions.get(3)),
                ()-> assertEquals(InstructionEnum.R,parseInstructions.get(4))
                );
    }
}