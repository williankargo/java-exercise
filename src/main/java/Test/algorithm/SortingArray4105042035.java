package Test.algorithm;

import edu.princeton.cs.algs4.In;

public class SortingArray4105042035 {

    public static void main(String[] args) {

        int[] A = {3, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //測資
        int array[] = readarray(
                "/Users/pinkuan/IdeaProjects/exercise/test/HW5test.txt"); //把測資file address放到裡面
        //System.out.println(Arrays.toString(brray));  //print array

        //標記時間起始
        long start = System.currentTimeMillis();

        sorting(array);

        //計算程式跑了多久
        elapsedTime(start);

        printArray(array);

    }

    //print array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //計算速度的東西
    public static void elapsedTime(long start) {
        long now = System.currentTimeMillis();
        long result = now - start;
        System.out.println("耗時：" + (result / 1000D) + " 秒");
    }

    //讀測資
    public static int[] readarray(String name) {
        In in = new In(name);

        int num = 100000;  //row長，我自己數
        int array[] = new int[num];

        int i = 0;
        while (i < num) {
            int x = in.readInt();
            array[i] = x;
            i = i + 1;
        }
        return array;
    }


    ///HW,由小排到大
    ///original version
    public static int[] sorting(int[] A) {
        if (A.length < 1000) {  //TODO
            if (Math.random() > 0.5) {
                shellSort(A);
            } else {
                insertionSort(A);
            }
        } else {
            if (Math.random() > 0.5) {  //TODO
                timSort(A);
            } else {
                quickSort(A, 0, A.length - 1);
            }
        }
        return A;
    }


    /**
     * shell sort
     */
    public static void shellSort(int[] array) {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
        int temp;
        int i, j;

        for (int gap : gaps) {
            for (i = gap; i < array.length; i++) {
                temp = array[i];
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }


    /**
     * Insertion sort
     */
    public static void insertionSort(int[] array) {
        int i;
        int key;

        for (int j = 1; j < array.length; j++) {
            key = array[j];
            i = j - 1;

            while ((i >= 0) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
        }
    }


    /**
     * Tim sort
     */

    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {

        int len1 = m - l + 1;
        int len2 = r - m;

        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++) {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++) {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void timSort(int[] array) {
        int RUN = 32;
        int n = array.length;
        for (int i = 0; i < n; i += RUN) {
            insertionSort(array, i, Math.min((i + 31), (n - 1)));
        }

        for (int size = RUN; size < n; size = 2 * size) {

            for (int left = 0; left < n; left += 2 * size) {

                int mid = Math.min((left + size - 1), (n - 1));
                int right = Math.min((left + 2 * size - 1), (n - 1));

                merge(array, left, mid, right);
            }
        }
    }

    /**
     * quick sort
     */
    public static void quickSort(int[] array, int left, int right) {
        int i, j, v;
        while (right > left) {
            j = right;
            i = left - 1;
            v = array[right];

            while (true) {
                do {
                    i++;
                } while (array[i] < v && i < j);
                do {
                    j--;
                } while (array[j] > v && i < j);

                if (i >= j) {
                    break;
                }

                swapKeys(array, i, j);

            }

            swapKeys(array, i, right);

            if ((i - 1 - left) <= (right - i - 1)) {
                quickSort(array, left, i - 1);
                left = i + 1;
            } else {
                quickSort(array, i + 1, right);
                right = i - 1;
            }
        }
    }

    public static void swapKeys(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

