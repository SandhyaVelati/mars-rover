package org.example.model;

import java.util.List;

public class Rover implements Movable<CompassDirectionEnum,InstructionEnum>{

    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position move(List<InstructionEnum> instructions) {
        for(InstructionEnum instruction: instructions){
            if(instruction == InstructionEnum.M){
               //todo: move ahead
                System.out.println("position before move:"+ this.position.toString());
                moveToNewXYPoints();
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

    public void moveToNewXYPoints(){
        if (this.position.getDirectionFacing() == CompassDirectionEnum.N){
            //y positive ahead
            this.setPosition(new Position(this.position.getX(), this.position.getY() + 1, this.position.getDirectionFacing()));
        }
        if (this.position.getDirectionFacing() == CompassDirectionEnum.E){
            //x positive ahead
            this.setPosition(new Position(this.position.getX()+1, this.position.getY() , this.position.getDirectionFacing()));
        }
        if (this.position.getDirectionFacing() == CompassDirectionEnum.S){
            //y negative ahead
            this.setPosition(new Position(this.position.getX(), this.position.getY() - 1, this.position.getDirectionFacing()));
        }
        if (this.position.getDirectionFacing() == CompassDirectionEnum.W){
            //x negative ahead
            this.setPosition(new Position(this.position.getX()-1, this.position.getY(), this.position.getDirectionFacing()));
        }
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
}
