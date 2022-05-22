package com.lzx.algorithm.sort;

import java.util.Arrays;
import java.util.Random;


/**
 * @author laizixiang
 */
public class Sort {
    public static boolean flag = false;
    private static int count = 0;

    public static void main(String[] args) {
        flag = true;
        int size = 10;
        int[] arr = new int[size];
        Random r = new Random(234795);
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(0, size);
        }
        System.out.println("排序前：" + Arrays.toString(arr));
        long startTime = System.currentTimeMillis();
        quickSort1(arr, 0, arr.length - 1);
        //Arrays.sort(arr);
        //shellSort1(arr);
        //insertionSort(arr);
        // selectionSort(arr);
        //bubbleSort(arr);
        System.out.printf("排序时间：%dms%n", System.currentTimeMillis() - startTime);
        System.out.println("排序后：" + Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr) {
        int temp;
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            //如果本轮没任何交换，则说明已经排序完成，应该退出循环。
            if (flag) {
                break;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int temp;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }

    }

    public static void selectionSort1(int[] arr) {

        int minIndex;
        int temp;
        for (int i = 1; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[minIndex] > arr[j + 1]) {
                    minIndex = j + 1;
                }
            }
            if (arr[i - 1] > arr[minIndex]) {
                temp = arr[i - 1];
                arr[i - 1] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            int j;
            temp = arr[j = i];
            if (temp < arr[j - 1]) {
                while (--j >= 0 && temp < arr[j]) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }

        }
    }

    public static void shellSort(int[] arr) {
        int temp;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                //交换式
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j - gap] > arr[j]) {
                        temp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = temp;

                    }
                }
            }
        }
    }

    public static void shellSort1(int[] arr) {

        int count = 0;
        int j;
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                temp = arr[i];
                //插入式
                if (arr[i] < arr[i - gap]) {
                    for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                        arr[j] = arr[j - gap];
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序，以在右边的一个数为基准数
     *
     * @param arr   带排序的数组
     * @param left  最右边的下表
     * @param right 最左边的下标
     */
    public static void quickSort(int[] arr, int left, int right) {
        int pivot = arr[left];
        int l = left;
        int r = right;
        int temp;
        while (l < r) {

            while (pivot <= arr[r] && l < r) {
                r--;
            }
            if (pivot > arr[r] && l < r) {
                arr[l] = arr[r];
            }

            while (pivot >= arr[l] && l < r) {
                l++;
            }
            if (pivot < arr[l] && l < r) {
                arr[r] = arr[l];
            }

        }
        arr[l] = pivot;
        //printArray(arr, ++count, flag);
        if (left < r) {
            quickSort(arr, left, r - 1);
        }
        if (right > l) {
            quickSort(arr, l + 1, right);
        }

    }

    /**
     * 快速排序，以最中间的数为基准数
     *
     * @param arr   带排序的数组
     * @param left  最右边的下表
     * @param right 最左边的下标
     */
    public static void quickSort1(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int l = left;
        int r = right;
        int temp;
        while (l < r) {

            while (pivot < arr[r]) {
                r--;
            }
            while (pivot >arr[l]) {
                l++;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if( l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }

        }// 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        printArray(arr, ++count, flag);
        if (left < r) {
            quickSort1(arr, left, r);
        }
        if (right > l) {
            quickSort1(arr, l, right);
        }

    }

    private static void printArray(int[] arr, int times, boolean flag) {
        if (flag) {
            System.out.printf("第%d排序", times);
            System.out.println(Arrays.toString(arr));
        }
    }

}
