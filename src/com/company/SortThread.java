package com.company;

public class SortThread implements Runnable{
    private  int[] arr;
    private Thread thr;

    public SortThread(int[] arr) {
        super();
        this.arr = arr;
        this.thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run() {
        ShellSort.Sort(arr);
    }

    public Thread getThread() {
        return thr;
    }
}
