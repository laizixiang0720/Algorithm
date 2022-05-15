package com.lzx.algorithm;

import java.util.Arrays;

/**
 * 八皇后问题
 */
public class EightQueens {

    public static void main(String[] args) {
       EightQueens e =new EightQueens();
       e.putChess(0);
    }
    private final int max =8;
    private final int[] arr = new int[max];

    public void putChess(int n){
        if(n==max){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n]=i;
            if(isValidLocation(n)){
                putChess(n+1);
            }

        }
    }

    public boolean isValidLocation(int n){
        for (int i = 0; i < n; i++) {
            if(arr[i]==arr[n]||Math.abs(arr[i]-arr[n])==Math.abs(i-n)){
                return false;
            }
        }
        return true;
    }
}
