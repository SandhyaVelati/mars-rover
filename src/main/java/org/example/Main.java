package org.example;


import org.example.model.*;
import org.example.parser.InstructionParser;
import org.example.parser.PlateauParser;
import org.example.parser.PositionParser;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //CompassDirection.validateDirection('H');
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
//        String plateauSizeInput = "   ";
//        String positionInput = "1 2 N";
//        String instructionInput = "LMLMRMLLM";
        System.out.println("Enter Plateau dimensions (e.g:, '5 5'):");
        String plateauInput = scanner.nextLine();
        PlateauParser plateauSizeParser = new PlateauParser();
        Plateau singlePlateauForEachRun = plateauSizeParser.parsePlateauSize(plateauInput);
        //todo: mission controller now has plateau returned by plateau Factory class
        MissionController missionController = new MissionController(singlePlateauForEachRun);
        System.out.println("Plateau surface is now available with dimension:" +singlePlateauForEachRun.toString());
        while (true){
            //todo: choose to deploy or not deploy
            System.out.println("\nHere to deploy a rover today (y/n):");
            String userResponse = scanner.nextLine().trim().toLowerCase();
            if(!userResponse.equals("y")){
                System.out.println("Thanks for the response, goodbye");
                break;
            }
            //todo: choose rover init position
            System.out.println("let's choose initial position for the rover to land on the plateau (e.g: 0 0 N)");
            String initPositionString = scanner.nextLine();
            PositionParser positionParser = new PositionParser();
            Position initPosition = positionParser.parsePositionString(initPositionString);

            //todo: create rover
            Rover rover = new Rover(initPosition);
            missionController.deployRoverOnPlateau(rover);

            //todo: move or turn rover
            System.out.println("Enter movement instructions for this Rover Left,Right or Move as(e.g., 'LMLMLMLMM'):");
            String instructionsString = scanner.nextLine();
            InstructionParser instructionParser = new InstructionParser();
            List<InstructionEnum> parsedInstructions = instructionParser.parseInstructions(instructionsString);
            missionController.driveRoverOnPlateau(rover,parsedInstructions);

            //todo: display rovers
            missionController.listRovers();
            System.out.println("=================================================================");
            System.out.println("Do you want to recall any of the rovers from listed above (y/n):");
            String userResponse2 = scanner.nextLine().trim().toLowerCase();
            if(!userResponse2.equals("y")){
                System.out.println("okay, I understand, goodbye");
                break;
            }else {
                System.out.println("select the index of the rover in the list, your list currently has "+ singlePlateauForEachRun.getRovers().size() +"elements" );
                missionController.recallRover(singlePlateauForEachRun.getRovers().get(scanner.nextInt()-1));
            }

        }
        
    }
}