package Test.OOD.quiz0407;


import java.util.Arrays;
import java.util.Scanner;

public class test040702 {

    public static void main(String[] args) {

        int[] ary = new int[10];
        //input a value
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Input upper bound: ");
        do {
            while (!in.hasNextInt()) {
                System.out.println("Not a positive integer!");
                System.out.println("Input upper bound: ");
                in.next();
            }
            num = in.nextInt();
            if (num <= 0) {
                System.out.println("Not a positive integer!");
                System.out.println("Input upper bound: ");
            }
        } while (num <= 0);

        //random create values in an array

        Sort s = new Sort();
        s.num = num;
        s.setAry(ary);
        System.out.println("Original array: " + Arrays.toString(ary));

        s.max();
        s.min();
        s.sort();
    }
}

class Sort {

    private int[] ary;
    public int num;


    public void setAry(int[] ary) {
        for (int i = 0; i < 10; i++) {
            ary[i] = (int) Math.floor(Math.random() * num);
        }
        this.ary = ary;
    }

    public void sort() {
        Arrays.sort(ary);
        System.out.println("Sort array:" + Arrays.toString(ary));

    }

    public void max() {
        int maxValue = ary[0];
        for (int i = 1; i < ary.length; i++) {
            if (ary[i] > maxValue) {
                maxValue = ary[i];
            }
        }
        System.out.println("Max is " + maxValue);
    }


    public void min() {
        int minValue = ary[0];
        for (int i = 1; i < ary.length; i++) {
            if (ary[i] < minValue) {
                minValue = ary[i];
            }
        }
        System.out.println("min is " + minValue);
    }
}
