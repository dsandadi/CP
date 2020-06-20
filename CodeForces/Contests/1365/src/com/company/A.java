package com.company;

public class A {
    public String fw(int[][] matrix){
        int rem = 0;
        for(int i = 0; i < matrix.length; i++){
            boolean valid = true;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    valid = false;
                    break;
                }
            }
            if(valid)
                rem++;
        }
        return rem % 2 == 0? "Vivek": "Ashish";
    }
    
}
