package Test.algorithm;


public class ShellSort {

    public static void main(String[] args) {
        int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        shellSort(a);
    }


    public static void shellSort(int[] array) {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
        int temp;
        int i, j;

        for (int gap : gaps) {
            for (i = gap; i < array.length; i++) {
                temp = array[i]; //先把一個保存起來來比較,懸掛在空中
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) { //(A;B;C) = A>B(if true,執行下面內容)>C
                    array[j] = array[j - gap]; //前後調換
                }
                array[j] = temp;
            }
        }
    }
}
//想成有間隔的insertion sort(間隔數字忽略)
//https://www.youtube.com/watch?v=qzXAVXddcPU
