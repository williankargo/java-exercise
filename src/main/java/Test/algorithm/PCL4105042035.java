package Test.algorithm;

import edu.princeton.cs.algs4.In;

import java.io.FileNotFoundException;

public class PCL4105042035 {

    public static void main(String[] args) throws FileNotFoundException {

        //測資
        //int brray[][] = readarray("./test_data.csv");
        //System.out.println(Arrays.deepToString(brray));  //print two dimensional array

        //小資料
        int array[][] = {{9, 8}, {0, 0}, {0, 1}, {2, 2}};

        long start = System.currentTimeMillis();
        checkPCL(array);
        elapsedTime(start);
    }

    public static boolean checkPCL(int[][] array) {

        int endpoint = array.length - 1;
        int k = 0;

        for (int i = 0; i < array.length - 1; i++) {
            long endx = array[endpoint][0];
            if (!(array[i][0] == endx)) { //三個沒有連在一起
                i = k;                      //i就他媽不准動
            } else {
                endpoint = array.length - 1; //如果擠在一起，就把尾巴退回去，然後i也可以動
            }
            endx = array[endpoint][0];
            long endy = array[endpoint][1];

            long startx = array[i][0];
            long starty = array[i][1];
            for (int j = i + 1; j < endpoint; j++) {
                long midx = array[j][0];
                long midy = array[j][1];
                long area = startx * (midy - endy) +
                        midx * (endy - starty) +
                        endx * (starty - midy);
                if (area == 0) {
//          System.out.println("true");
//          System.out.println(
//              "startx: " + startx + " starty: " + starty + " midx: " + midx + " midy: " + midy
//                  + " endx: "
//                  + endx + " endy: "
//                    + endy);
                    return true;
                }
            }
            k = i;  //存舊i
            endpoint = endpoint - 1;
        }
//    System.out.println("false");
        return false;
    }

    //計算速度的東西
    public static void elapsedTime(long start) {
        long now = System.currentTimeMillis();
        long result = now - start;
        System.out.println("耗時：" + (result / (long) 1000D) + " 秒");
    }


    //讀測資
    public static int[][] readarray(String name) {
        In in = new In(name);

        int num = 10000;
        int array[][] = new int[num][2];

        int i = 0;
        while (i < num) {
            int x = in.readInt();
            int y = in.readInt();
            array[i][0] = x;
            array[i][1] = y;
            i = i + 1;
        }
        return array;
    }
}

