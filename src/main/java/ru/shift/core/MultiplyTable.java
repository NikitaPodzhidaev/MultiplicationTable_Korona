package ru.shift.core;

public class MultiplyTable {

    public static int[][] getTableOfNumbers(int size){
        int[][] arrayOfNumbers = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                arrayOfNumbers[i][j] = (i+1)*(j+1);
            }
        }
        return arrayOfNumbers;
    }

}
