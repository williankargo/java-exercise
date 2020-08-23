package lambda;

import java.util.Arrays;

public class ParallelSortDemo {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        //can't use forEach lambda
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println("\nAfter sorting! ");

        Arrays.parallelSort(arr, 1, 3);  //可以指定要sort的index


        for (int i : arr) {
            System.out.print(i + " ");
        }


    }


}
