package org.example.parser;



import com.sun.source.tree.PatternTree;
import org.example.model.InstructionEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InstructionParser {
    //LMLMMLLMMMR
    public List<InstructionEnum> parseInstructions(String instructions){
        if(instructions==null || instructions.isBlank() || instructions.isEmpty()){
            throw new IllegalArgumentException("Instructions cannot be blank");
        }
        if(!instructions.matches("[LRM]*")){
            throw new IllegalArgumentException("Invalid Instruction found in the input, please pass L-to turn Left, R-to turn Right and M- to move a block");
        }
        List<InstructionEnum> ListOfInstructions = new ArrayList<>();
        for(char instruction: instructions.toCharArray()){
            if (instruction == 'L')
                ListOfInstructions.add(InstructionEnum.L);
            if (instruction == 'R')
                ListOfInstructions.add(InstructionEnum.R);
            if (instruction == 'M')
                ListOfInstructions.add(InstructionEnum.M);
        }
        return ListOfInstructions;
    }
}
