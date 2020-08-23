package Test.algorithm;


import edu.princeton.cs.algs4.In;

public class MPI4105042035 {

    /****** test ******/
    public static void main(String[] args) {

        //small simple
        int arr[] = {0, 10, 1, -10, -20};

        //測資 ( 把測資file address放到裡面 )
//    int array3[] = readarray(
//        "/Users/pinkuan/IdeaProjects/exercise/test/final_test_data.txt");

        //標記時間起始
        long start = System.currentTimeMillis();

        //我寫的程式
        int ans = min(arr);
        System.out.println(ans);

        //計算程式跑了多久
        elapsedTime(start);

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

        int num = 20000;  //row長，我自己數
        int array[] = new int[num];

        int i = 0;
        while (i < num) {
            int x = in.readInt();
            array[i] = x;
            i = i + 1;
        }
        return array;
    }


    /**********************************************************/

    public static int min(int array[]) {

        int arr_size = array.length;
        int shift = segregate(array, arr_size);
        int arr2[] = new int[arr_size - shift]; //建立新 positive array
        int j = 0;
        for (int i = shift; i < arr_size; i++) {
            arr2[j] = array[i];
            j++;
        }
        return findMissingPositive(arr2, j);
    }

    // 就是一個交換的動作，把負或0放array最前面，return的j是分界點（前負後正）
    private static int segregate(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }

    private static int findMissingPositive(int arr[], int size) {

        for (int i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0) {
                arr[x - 1] = -arr[x - 1];
            }
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return size + 1;
    }
}


/**
 * simple to know
 */
//  static int min(int A[]) {
//
//    int N = A.length;
//    Set<Integer> set = new HashSet<>();
//    for (int a : A) {
//      if (a > 0) {
//        set.add(a);
//      }
//    }
//    for (int i = 1; i <= N + 1; i++) {
//      if (!set.contains(i)) {
//        return i;
//      }
//    }
//  }
//如果排序好的正數array，第一個數字是1，那最大會返回(array.length+1)
//如果第一個數字不是1，那返回1
