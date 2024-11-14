package org.example;


import org.example.parser.InstructionParser;
import org.example.parser.PlateauSizeParser;
import org.example.parser.PositionParser;

public class Main {
    public static void main(String[] args) {
        //CompassDirection.validateDirection('H');
        System.out.println("Hello world!");
        String plateauSizeInput = "   ";
        String positionInput = "1 2 N";
        String instructionInput = "LMLMRMLLM";
//
        PlateauSizeParser plateauSizeParser = new PlateauSizeParser();
        //PositionParser positionParser = new PositionParser();
        //InstructionParser instructionParser = new InstructionParser();
//
        System.out.println(plateauSizeParser.parsePlateauSize(plateauSizeInput));
//        System.out.println(positionParser.parsePositionString(positionInput));
//        System.out.println(instructionParser.parseInstructions(instructionInput));
    }
}