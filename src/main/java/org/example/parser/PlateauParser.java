package org.example.parser;


import org.example.model.Plateau;

public class PlateauParser {
    //convert plateau size dimensions input to PlateauSize Type : 5 5
    public Plateau parsePlateauSize(String plateauSizeInput){
        if(plateauSizeInput == null || plateauSizeInput.isBlank() || plateauSizeInput.isEmpty()){
            throw new IllegalArgumentException("plateau size cannot be empty");
        }
        String[] PlateauLengthAndWidth = plateauSizeInput.split(" ");
        if(PlateauLengthAndWidth.length != 2){
            throw new IllegalArgumentException("one or more dimensions missing from the input");
        }
        int maxX = Integer.parseInt(PlateauLengthAndWidth[0]);
        int maxY = Integer.parseInt(PlateauLengthAndWidth[1]);
        return new Plateau(maxX,maxY);
    }
}