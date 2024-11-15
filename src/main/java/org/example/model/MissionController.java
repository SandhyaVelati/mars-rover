package org.example.model;

import java.util.List;

public class MissionController {
    private final Plateau plateau;

    public MissionController(int maxX, int maxY) {
        this.plateau = Plateau.getInstance(maxX, maxY);
    }
    public void deployRoverOnPlateau(Rover rover){
        plateau.addRover(rover);
    }
    public void driveRoverOnPlateau(Rover rover, List<InstructionEnum> instructions,Plateau plateau){
        rover.move(instructions, plateau);
    }
    public void recallRover(Rover rover) {
        plateau.removeRoverFromPlateau(rover);
    }
    public void listRovers() {
        plateau.getRovers().forEach(rover -> System.out.println(rover.getRoverId() + " at " + rover.getPosition()));
    }

}
