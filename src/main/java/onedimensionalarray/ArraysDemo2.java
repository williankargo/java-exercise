package onedimensionalarray;

import java.util.Arrays;

public class ArraysDemo2 {

    public static void main(String[] args) {

        double[] numbers = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers)); //1

        for (double item : numbers) {   //2
            System.out.print(item + " ");
        }

        System.out.println();

        int[] list = {2, 4, 6, 8, 10, 12, 14, 15};
        System.out.println("index: " + Arrays.binarySearch(list, 12));
        System.out.println(Arrays.binarySearch(list, 11));  //找不到傳回負值
    }
}
