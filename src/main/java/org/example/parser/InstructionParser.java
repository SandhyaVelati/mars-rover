package org.example.parser;



import org.example.model.InstructionEnum;

import java.util.ArrayList;
import java.util.List;

public class InstructionParser {
    //LMLMMLLMMMR
    public List<InstructionEnum> parseInstructions(String instructions){
        if(instructions.isBlank() || instructions.isEmpty()){
            throw new RuntimeException("Instructions cannot be blank");
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
