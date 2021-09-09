package com.company;

import java.util.Random;

public class Helper {

    public static void FillArrayRandom(int[] arr) {
        Random rn = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(10);
        }
    }
}
