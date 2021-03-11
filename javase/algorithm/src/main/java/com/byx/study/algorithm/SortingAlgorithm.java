package com.byx.study.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wang zhen xing
 * @date 2021/3/11 10:29
 */
public class SortingAlgorithm {


    public static void main(String[] args) {
        /*String a = "1";
        String b = new String("1");
        System.out.println(a == b);*/
        int[] arr = {1, 5, 4, 8, 7, 9, 6, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param data
     */
    public static void selectionSort(int[] data) {
        int minVal;
        int minIndex;
        for (int i = 0; i < data.length; i++) {
            minIndex = i;
            minVal = data[i];
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < minVal) {
                    minIndex = j;
                    minVal = data[j];
                }
                if (minIndex != i && minVal != data[i]) {
                    data[minIndex] = data[i];
                    data[i] = minVal;
                }
            }
        }
    }

    /**
     * 插入排序
     * @param data
     */
    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
    }

    @Test
    void test05() {
        int[] arr = {5, 3, 4, 6, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }



}
