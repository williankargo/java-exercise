package onedimensionalarray;

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String[] args) {
        double[] numbers = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
        Arrays.sort(numbers);

        for (double e : numbers) {
            System.out.print(e + " ");
        }

        System.out.println();

        char[] chars = {'a', 'A', '4', 'F', 'D', 'P'};
        Arrays.sort(chars);
        System.out.println(chars);

        int[] list = {12, 31, 4, 1, 6, 8, 1};
        int[] list1 = {31, 12, 4, 1, 6, 8, 1};

        int index = Arrays.binarySearch(list, -1);
        System.out.println("index = " + index);

        boolean flag = Arrays.equals(list, list1);
        System.out.println("flag= " + flag);

        Arrays.fill(list, 666);
        System.out.println(Arrays.toString(list)); //快速，不用for迴圈印出數組的方式

    }

}
