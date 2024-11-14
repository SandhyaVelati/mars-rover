package org.example.parser;


import org.example.model.PlateauSize;

public class PlateauSizeParser {
    //convert plateau size dimensions input to PlateauSize Type : 5 5
    public PlateauSize parsePlateauSize(String sizeInput){
        if(sizeInput.isBlank() || sizeInput.isEmpty()){
            throw new RuntimeException("plateau size cannot be empty");
        }
        String[] PlateauLengthAndWidth = sizeInput.split(" ");
        int maxX = Integer.parseInt(PlateauLengthAndWidth[0]);
        int maxY = Integer.parseInt(PlateauLengthAndWidth[1]);
        return new PlateauSize(maxX,maxY);
    }
}
