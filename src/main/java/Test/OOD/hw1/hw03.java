package Test.OOD.hw1;

import java.util.Scanner;

public class hw03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("有個8*8的棋盤，請輸入Queen的起始位置(row,column)，以及移動距離(k)");

        //row
        int row = 9;
        while (row > 8 || row < 1) {
            System.out.println("row: ");
            row = input.nextInt();
            if (row > 8 || row < 1) {
                System.out.println("超過棋盤面積！請重新輸入");
            }
        }
        //column
        int column = 9;
        while (column > 8 || column < 1) {
            System.out.println("column: ");
            column = input.nextInt();
            if (column > 8 || column < 1) {
                System.out.println("超過棋盤面積！請重新輸入");
            }
        }
        //k
        System.out.println("K: ");
        int k = input.nextInt();
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        for (int i = 0; i < k + 1; i++) {
            left = row - i;
            if (left < 1) {
                left = left + 1;
                break;
            }
        }
        for (int i = 0; i < k + 1; i++) {
            right = row + i;
            if (right > 8) {
                right = right - 1;
                break;
            }
        }

        for (int i = 0; i < k + 1; i++) {
            up = column + i;
            if (up > 8) {
                up = up - 1;
                break;
            }
        }
        for (int i = 0; i < k + 1; i++) {
            down = column - i;
            if (down < 1) {
                down = down + 1;
                break;
            }
        }

        int Weight = (right - left) + 1;
        int Long = (up - down) + 1;

        int answer = Weight * Long;
        System.out.println("Queen可以到達 " + answer + " 格");

    }
}