package TwoDimension;

import java.util.Scanner;

public class PrintTwoDimensionArray {

    //initialize array
    public static void main(String[] args) {
        double[][] matrix = new double[2][2];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter " + matrix.length + " rows and " + matrix[0].length
                + " columns:");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextInt();
            }
        }
        printArray(matrix);
        maxRow(matrix);

    }

    //print
    public static void printArray(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //sum
    public static void sum(double[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j];
            }
            System.out.println(sum);
        }
    }

    //maxRow
    public static void maxRow(double[][] matrix) {
        int maxRow = 0;
        int indexOfMaxRow = 0;

        //先把row 0's sum設為max
        for (int column = 0; column < matrix[0].length; column++) {
            maxRow += matrix[0][column];
        }

        for (int row = 1; row < matrix.length; row++) {
            int totalOfThisRow = 0;
            for (int column = 0; column < matrix[row].length; column++) {
                totalOfThisRow += matrix[row][column];

                if (totalOfThisRow > maxRow) {
                    maxRow = totalOfThisRow;
                    indexOfMaxRow = row;
                }
            }
        }
        System.out.println("Row= " + indexOfMaxRow + "'s maxValue = " + maxRow);
    }


}
