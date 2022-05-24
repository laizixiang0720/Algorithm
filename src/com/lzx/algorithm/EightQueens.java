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

    /**
     * 放置棋子
     * @param n 放置第几行棋子
     */
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

    /**
     * 测试该行是否能放棋子。
     * @param n 被测试的行。
     * @return 返回测试结果。
     */
    public boolean isValidLocation(int n){
        for (int i = 0; i < n; i++) {
            if(arr[i]==arr[n]||Math.abs(arr[i]-arr[n])==Math.abs(i-n)){
                return false;
            }
        }
        return true;
    }
}
