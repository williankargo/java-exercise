package Test.algorithm;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Collections;

//ArrayList動態增刪
//Collections協助sort

public class LSPath4105042035 {

    /****** test ******/
    public static void main(String[] args) {

        // small sample
//    int[][] array = new int[][]{{5, 6}, {6, 7}, {7, 8}, {7, 14}, {7, 9}, {9, 10}, {6, 11}, {11, 12},
//        {11, 13}};
//    int[][] array2 = new int[][]{{5, 6}, {6, 7}, {7, 8}};

        //測資 ( 把測資file address放到裡面 )
        int array3[][] = readarray(
                "/Users/pinkuan/IdeaProjects/exercise/test/MaxGraph.txt");

        //標記記憶體起始用量
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        //標記時間起始
        long start = System.currentTimeMillis();

        //我寫的程式
        Ans(array3);

        //計算程式跑了多久
        elapsedTime(start);

        //標記記憶體最終用量
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        //印出記憶體用量
        long actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.println("Memory use: " + actualMemUsed);

        //print 2-dimensional array
//    System.out.println(Arrays.deepToString(array3));

    }

    //計算速度的東西
    public static void elapsedTime(long start) {
        long now = System.currentTimeMillis();
        long result = now - start;
        System.out.println("耗時：" + (result / 1000D) + " 秒");
    }

    //讀測資
    public static int[][] readarray(String name) {
        In in = new In(name);

        int num = 398;  //TODO: need to change
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

    //計算速度的東西
    public static void elapsedTimes(long start) {
        double now = System.currentTimeMillis();
        double result = now - start;
        System.out.println("耗時：" + (result / (double) 1000D) + " 秒");
    }

    /************/


    public static int Ans(int[][] array) {

        //找出所有相異的node
        ArrayList<Integer> totalItems = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (!totalItems.contains(array[i][j])) {
                    totalItems.add(array[i][j]);
                }
            }
        }
        Collections.sort(totalItems);  //由小到大排列

        int VNum = totalItems.size();

        //先把圖建起來
        Graph example = new Graph(VNum, totalItems);
        for (int[] item : array) {
            //用index順序而不是值來addEdge
            example.addEdge(totalItems.indexOf(item[0]), totalItems.indexOf(item[1]));
        }

        Pair<Integer, Integer> t1, t2;
        t1 = example.BFS(array[0][0]);
        t2 = example.BFS(t1.node);

        //TODO:檢查用
        System.out.println("Longest path is from " + t1.node
                + " to " + t2.node + " of length " + t2.value);

        return t2.value;
    }

    // create Pair
    static class Pair<N, V> {

        N node;
        V value;

        Pair(N node, V value) {
            this.node = node;
            this.value = value;
        }
    }

    //以adjacency matrix 實現Graph
    static class Graph {

        private final int VNum;
        private int[][] adjMatrix;
        private ArrayList totalItems;


        Graph(int VNum, ArrayList totalItems) {
            this.VNum = VNum;
            this.totalItems = totalItems;

            adjMatrix = new int[VNum][VNum];
            for (int row = 0; row < VNum; row++) {
                for (int column = 0; column < VNum; column++) {
                    adjMatrix[row][column] = 0;
                }
            }
        }

        public void addEdge(int oneIndex, int twoIndex) {
            adjMatrix[oneIndex][twoIndex] = 1;
            adjMatrix[twoIndex][oneIndex] = 1;
        }

        //find adjacent nodes
        private ArrayList findAdjacent(int nodeIndex) {

            ArrayList adjacentBrothers = new ArrayList();
            for (int i = 0; i < VNum; i++) {
                if (adjMatrix[nodeIndex][i] == 1) {
                    adjacentBrothers.add(totalItems.get(i));
                }
            }
            return adjacentBrothers;
        }

        //method returns farthest node and its distance from node start
        public Pair<Integer, Integer> BFS(int rootValue) {

            int[] dis = new int[VNum];

            //mark all distance with -1
            for (int i = 0; i < VNum; i++) {
                dis[i] = -1;
            }

            ArrayList<Integer> queue = new ArrayList<>();

            queue.add(rootValue);

            // distance of start from start will be 0
            dis[totalItems.indexOf(rootValue)] = 0;
            while (!queue.isEmpty()) {

//TODO: 以ArrayList實現的queue可能有問題，如果行不通，想著用stack實現

                // ArrayList remove第一個item後，其他items 會！往！前！
                int tValue = queue.remove(0);

                // loop for all adjacent nodes of node t
                for (Object wValue : findAdjacent(totalItems.indexOf(tValue))) {

//          System.out.println("baseOn: " + tValue);
//          System.out.print("value: "+(int) wValue);
//          System.out.println("===========================");

                    //push node into queue only if it is not visited already
                    if (dis[totalItems.indexOf(wValue)] == -1) {
                        queue.add((Integer) wValue);
                        // make distance of wValue one more than distance of tValue
                        dis[totalItems.indexOf(wValue)] = dis[totalItems.indexOf(tValue)] + 1;
                    }
                }
            }

            int maxDis = 0;
            int nodeIdx = 0;

            //get farthest node distance and its index
            for (int i = 0; i < VNum; i++) {
                if (dis[i] > maxDis) {
                    maxDis = dis[i];
                    nodeIdx = i;
                }
            }
            int node = (int) totalItems.get(nodeIdx);
            return new Pair<>(node, maxDis);
        }
    }
}
