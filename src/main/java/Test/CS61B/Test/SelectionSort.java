package Test.CS61B.Test;

public class SelectionSort {

    public static void sort(String[] x) {
        sort(x, 0);
    }


    private static void sort(String[] x, int start) {
        if (start == x.length) {  //終止條件
            return;
        }
        int smallestIndex = findSmallest(x, start);  //找到最小值
        swap(x, start, smallestIndex);  //和頭交換
        sort(x, start + 1); //recursion

    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallestIndex]);  //if x[i]<x[smallestIndex], return -1
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
