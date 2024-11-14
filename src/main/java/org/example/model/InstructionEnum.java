package org.example.model;

public enum InstructionEnum {
    L,
    R,
    M;

    //accept only valid instruction input characters
    public static InstructionEnum validateInstructionIP(char lRM){
        switch (lRM){
            case 'L' : return L;
            case 'R' : return R;
            case 'M' : return M;
            default: throw new IllegalArgumentException("Invalid instruction in the instructions set, please use 'L'-to turn Left, R-to turn Right and M- to move");
        }
    }


}
