package com.company;

public class MultiThreadsShellSort implements Runnable{
    private int[] arr;
    private Thread thr;

    public MultiThreadsShellSort(int[] arr) {
        this.arr = arr;
        this.thr = new Thread(this);
        thr.start();
    }

    private void Sort(int[] array) {
        int size1 = array.length/2;
        int size2 = array.length - size1;
        int[] firstPart = new int[size1];
        int[] secondPart = new int[size2];

        System.arraycopy(array, 0, firstPart,0, size1);
        System.arraycopy(array, size1, secondPart, 0, size2);

        try {
            SortThread firstThread = new SortThread(firstPart);
            SortThread secondThread = new SortThread(secondPart);
            firstThread.getThread().join();
            secondThread.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arr = merge(firstPart, secondPart);
    }

    @Override
    public void run() {
        Sort(arr);
    }

    private int[] merge(int[] part1, int[] part2) {
        int length = part1.length + part2.length;
        int[] merged = new int[length];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < length; i++) {
            if (i1 == part1.length) {
                merged[i] = part2[i2++];
            } else if (i2 == part2.length) {
                merged[i] = part1[i1++];
            } else {
                if (part1[i1] < part2[i2]) {
                    merged[i] = part1[i1++];
                } else {
                    merged[i] = part2[i2++];
                }
            }
        }
        return merged;
    }

    public int[] getArr() {
        return arr;
    }

    public Thread getThread() {
        return thr;
    }
}
