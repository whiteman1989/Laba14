package com.company;

public class ShellSort {
    public static int[] Sort(int[] array) {
        int length = array.length;
        int semi = length / 2;
        while (semi > 0) {
            for (int i = 0; i < length - semi; i++) {
                int j = i;
                while ((j >= 0) && array[j] > array[j + semi]) {
                    int temp = array[j];
                    array[j] = array[j + semi];
                    array[j + semi] = temp;
                    j--;
                }
            }
            semi /= 2;
        }
        return array;
    }
}
