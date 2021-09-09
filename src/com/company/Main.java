package com.company;

public class Main {

    public static void main(String[] args) {
        long start;
        long end;
        int arrSize = 1000000;

        int[] firstArr = new int[arrSize];
        int[] secondArr = new int[arrSize];

        Helper.FillArrayRandom(firstArr);
        System.arraycopy(firstArr, 0, secondArr, 0 , arrSize);

        try {
            start = System.currentTimeMillis();
            ShellSort.Sort(firstArr);
            end = System.currentTimeMillis();
            System.out.println("Single-threaded Shell sorting.\nTime: " + (end - start) + "ms. Array length is " + firstArr.length + "\n");

            start = System.currentTimeMillis();
            MultiThreadsShellSort mss = new MultiThreadsShellSort(secondArr);
            mss.getThread().join();
            secondArr = mss.getArr();
            end = System.currentTimeMillis();
            System.out.println("Multithreaded Shell sorting.\nTime: " + (end - start) + "ms. Array length is " + secondArr.length);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

    }
}
