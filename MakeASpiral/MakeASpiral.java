package com.company;

public class MakeASpiral {
    public static int[][] spiralize(int size) {
        int[][] ret = new int[size][size];
        int up = 0, down = size, left = 0, right = size;
        while(up < down && left < right) {
            for(int i = left; i < right; i++) {
                ret[up][i] = 1;
            }
            up += 2;
            if(up >= down && left >= right) break;
            for(int i = up - 2; i < down; i++){
                ret[i][right - 1] = 1;
            }
            right -= 2;
            if(up >= down && left >= right) break;
            for(int i = right + 1; i >= left; i--) {
                ret[down - 1][i] = 1;
            }
            down -= 2;
            if(up >= down && left >= right) break;
            for(int i = down + 1; i >= up; i--){
                ret[i][left] = 1;
            }
            left += 2;
            if(left < right) ret[up][left-1] = 1;
        }
        return ret;
    }
}
