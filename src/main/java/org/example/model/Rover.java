package org.example.model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Rover implements Movable<CompassDirectionEnum,InstructionEnum, Plateau>{

    private Position position;
    private final String roverId;

    public Rover(Position position) {
        this.roverId = UUID.randomUUID().toString();
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getRoverId() {
        return roverId;
    }

    @Override
    public Position move(List<InstructionEnum> instructions, Plateau plateau) {
        for(InstructionEnum instruction: instructions){
            if(instruction == InstructionEnum.M){
               //todo: move ahead
                System.out.println("position before move:"+ this.position.toString());
                moveToNewXYPoints(plateau);
                System.out.println("position after move:"+ this.position.toString());
            }
            else {
                //todo: turn around
                System.out.println("direction before turning:"+ this.position.toString());
                turn(instruction);
                System.out.println("direction after turning:"+ this.position.toString());
            }
        }
        return this.position;
    }

    public void moveToNewXYPoints(Plateau plateau){
        if (this.position.getDirectionFacing() == CompassDirectionEnum.N){
            //y positive ahead
            Position calcPos = new Position(this.position.getX(), this.position.getY() + 1, this.position.getDirectionFacing());
            if(plateau.isWithinBoundary(calcPos)){
                this.setPosition(calcPos);
            }
            else stop();

        }
        if (this.position.getDirectionFacing() == CompassDirectionEnum.E){
            //x positive ahead
            Position calcPos = new Position(this.position.getX()+1, this.position.getY() , this.position.getDirectionFacing());
            if(plateau.isWithinBoundary(calcPos)){
                this.setPosition(calcPos);
            }       else stop();
        }
        if (this.position.getDirectionFacing() == CompassDirectionEnum.S){
            //y negative ahead
            Position calcPos = new Position(this.position.getX(), this.position.getY() - 1, this.position.getDirectionFacing());
            if(plateau.isWithinBoundary(calcPos)){
                this.setPosition(calcPos);
            }   else stop();
        }
        if (this.position.getDirectionFacing() == CompassDirectionEnum.W){
            //x negative ahead
            Position calcPos = new Position(this.position.getX()-1, this.position.getY(), this.position.getDirectionFacing());
            if(plateau.isWithinBoundary(calcPos)){
                this.setPosition(calcPos);
            } else stop();        }
    }


    @Override
    public Position turn(InstructionEnum instruction) {
       if(instruction== InstructionEnum.L){
           this.setPosition(new Position(this.position.getX(),this.position.getY(),this.position.getDirectionFacing().turnLeft()));
       }
       else if(instruction== InstructionEnum.R){
            this.setPosition(new Position(this.position.getX(),this.position.getY(),this.position.getDirectionFacing().turnRight()));
        }
       else throw new IllegalArgumentException("Invalid Rotation Instruction, turn Rover command could not be executed");
        return this.position;
    }

    @Override
    public Position stop() {
        System.out.println("stopping rover from moving any further");
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(roverId, rover.roverId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(roverId);
    }
}
