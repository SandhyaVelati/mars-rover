package org.example;


import org.example.parser.PlateauParser;

public class Main {
    public static void main(String[] args) {
        //CompassDirection.validateDirection('H');
        System.out.println("Hello world!");
        String plateauSizeInput = "   ";
        String positionInput = "1 2 N";
        String instructionInput = "LMLMRMLLM";
//
        PlateauParser plateauSizeParser = new PlateauParser();
        //PositionParser positionParser = new PositionParser();
        //InstructionParser instructionParser = new InstructionParser();
//
        System.out.println(plateauSizeParser.parsePlateauSize(plateauSizeInput));
//        System.out.println(positionParser.parsePositionString(positionInput));
//        System.out.println(instructionParser.parseInstructions(instructionInput));
    }
}