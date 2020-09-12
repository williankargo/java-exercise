package Test.algorithm;

import edu.princeton.cs.algs4.In;

public class testfile {

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


    public static int[] sorting(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }

    public static void quickSort(int A[], int lo, int hi) {
        int pivotPoint;

        if (lo < hi) {
            pivotPoint = partition(A, lo, hi);
            quickSort(A, lo, pivotPoint - 1);
            quickSort(A, pivotPoint + 1, hi);
        }
    }

    private static int partition(int A[], int lo, int hi) {
        int pivotValue, pivotIndex, mid;
        mid = (hi + lo) / 2;
        swap(A, lo, mid);
        pivotIndex = lo;
        pivotValue = A[lo];
        for (int i = lo + 1; i <= hi; i++) {
            if (A[i] < pivotValue) {
                pivotIndex++;
                swap(A, pivotIndex, i);
            }
        }
        swap(A, lo, pivotIndex);
        return pivotIndex;
    }

    private static void swap(int[] A, int a, int b) {
        int temp;
        temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static class exercise2 {

        class Solution {

            int MAX_EDGE_VAL = 1000;

            public int[] findRedundantConnection(int[][] edges) {
                DSU dsu = new DSU(MAX_EDGE_VAL + 1);
                for (int[] edge : edges) {
                    if (!dsu.union(edge[0], edge[1])) {
                        return edge;
                    }
                }
                throw new AssertionError();
            }
        }

        class DSU {

            int[] parent;
            int[] rank;

            public DSU(int size) {
                parent = new int[size];
                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                }
                rank = new int[size];
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public boolean union(int x, int y) {
                int xr = find(x), yr = find(y);
                if (xr == yr) {
                    return false;
                } else if (rank[xr] < rank[yr]) {
                    parent[xr] = yr;
                } else if (rank[xr] > rank[yr]) {
                    parent[yr] = xr;
                } else {
                    parent[yr] = xr;
                    rank[xr]++;
                }
                return true;
            }
        }
    }
}
