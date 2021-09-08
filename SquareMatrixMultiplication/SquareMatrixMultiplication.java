package com.company;

public class SquareMatrixMultiplication {

    public static int[][] evaluate(int[][]a, int[][]b){
        int[][] result = new int[a.length][a.length];
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                result[i][j] = 0;
                for(int k = 0; k < a.length; k++){
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}
