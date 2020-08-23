package TwoDimension;

import java.util.Scanner;

public class SudokuSolution {

    public static void main(String[] args) {
        //Read a Sudoku solution
        int[][] grid = readASolution();

        System.out.println(isValid(grid) ? "Valid" : "inValid"); //true > Valid; false > inValid


    }

    //自己輸入完整數字們
    public static int[][] readASolution() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Sudoku puzzle solution:");
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = input.nextInt();
            }
        }
        return grid;
    }

    public static boolean isValid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {            //!: 不等於的意思
                if (grid[i][j] < 1 || grid[i][j] > 9 || !isValid(i, j, grid)) {  //再創造一個方法
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int i, int j, int[][] grid) {
        //check whether grid[i][j] is valid in the i's row 1-9
        for (int column = 0; column < 9; column++) {
            if (column != j && grid[i][column] == grid[i][j]) {
                return false;
            }
            return true;
        }
        //check whether grid[i][j] is valid in the i's column 1-9
        for (int row = 0; row < 9; row++) {
            if (row != i && grid[row][j] == grid[i][j]) {
                return false;
            }
        }
        //check whether grid[i][j] is valid in the 3 by 3 box
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {//(i/3)*3為row & column 的起始位置
            for (int col = (i / 3) * 3; col < (i / 3) + 3; col++) {
                if (row != i && col != j && grid[row][col] == grid[i][j]) {
                    return false;
                }
            }
        }
        return true;//the current value at grid[i][j] is valid
    }
}
