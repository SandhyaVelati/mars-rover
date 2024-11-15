package org.example.model;

import java.util.List;

public class MissionController {
    private final Plateau plateau;

    public MissionController(Plateau plateau) {
        this.plateau = plateau;
    }
    public void deployRoverOnPlateau(Rover rover){
        plateau.addRover(rover);
    }
    public void driveRoverOnPlateau(Rover rover, List<InstructionEnum> instructions){
        rover.move(instructions, this.plateau);
    }
    public void recallRover(Rover rover) {
        plateau.removeRoverFromPlateau(rover);
    }
    public void listRovers() {
        plateau.getRovers().forEach(rover -> System.out.println("Rover Id:  "+rover.getRoverId() + "  at " + rover.getPosition()));
    }

}
