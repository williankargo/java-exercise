package Test.algorithm;

import edu.princeton.cs.algs4.In;

public class slash4105042035 {

    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 10, 11, 20, 30, 32, 33, 36, 0, 1, 2, 3, 4};

        //測資
        int array[] = readarray(
                "/Users/pinkuan/IdeaProjects/exercise/test/HW5test.txt"); //把測資file address放到裡面
        //System.out.println(Arrays.toString(array));  //print two dimensional array

        //標記時間起始
        long start = System.currentTimeMillis();

        slash_min(A);  //supposed return 499

        //計算程式跑了多久
        elapsedTime(start);
    }

    public static int slash_min(int[] A) {

        int finalIndex = A.length - 1;  //尾index(不變)

        //need to find the first small as start
        int startI = 0;  //startIndex
        int endI = A.length - 1;  //endIndex


        while (!(startI + 1 == endI)) {
            //外面的不會自動更新，要手動更新
            int midI = (startI + endI) / 2;
            int start = A[startI];  //startNumber
            int end = A[endI];  //endNumber
            int mid = A[midI];  //midNumber

            if (mid > start & mid > end) {
                startI = midI;  //以midIndex為頭往右縮小
            } else if (mid < start & mid < end) {
                endI = midI;  //以midIndex為尾往左縮小
            }
        }
        int answer = finalIndex - startI; //答案
        System.out.println(answer);
        return answer;
    }

    //計算速度的東西
    public static void elapsedTime(long start) {
        long now = System.currentTimeMillis();
        long result = ((now - start) / 1000);

        System.out.println("耗時：" + result + " 秒");
    }

    //讀測資
    public static int[] readarray(String name) {
        In in = new In(name);

        int num = 100009;
        int array[] = new int[num];

        int i = 0;
        while (i < num) {
            int x = in.readInt();
            array[i] = x;
            i = i + 1;
        }
        return array;
    }

}
