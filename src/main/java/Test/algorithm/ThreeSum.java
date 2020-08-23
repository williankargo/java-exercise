package Test.algorithm;


public class ThreeSum {

    public static void main(String[] args) {
        int[] array = new int[10000];
        for (int a = 0; a < array.length; ++a) {
            array[a] = (int) (Math.random() * 100 - 50);
        }
        long start = System.currentTimeMillis();

        System.out.println(T_sum(array));
        elapsedTime(start);
    }

    //計算速度的東西
    public static void elapsedTime(long start) {
        long now = System.currentTimeMillis();
        long result = now - start;
        System.out.println("耗時：" + (result / (long) 1000) + " 秒");
    }


    //3sum fast
    public static int T_sum(int[] a) {
        heapSort(a);
        //bubbleSorting(a);
        int cnt = 0;
        for (int i = 0; i < a.length - 3; i++) {
            int start = i + 1;
            int end = a.length - 1;

            while (start < end) {
                if (a[i] + a[start] + a[end] == 0) {
                    cnt++;
                }
                if (a[i] + a[start] + a[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return cnt;
    }

    //大小排序
    static void bubbleSorting(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {   // 小至大 ,調轉就是大至小
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //binary search
    public static int rank(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static void heapify(int[] array, int length, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        // if the left child is larger than parent
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // if the right child is larger than parent
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // if a swap needs to occur
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public static void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        // Building the heap
        int length = array.length;
        // we're going from the first non-leaf to the root
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }


}
