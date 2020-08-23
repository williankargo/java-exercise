package onedimensionalarray;

import java.util.Scanner;

public class demo2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] myList = new double[3];
//    System.out.println("Enter " + myList.length + " values:");
//    for (int i = 0; i < myList.length; i++) {
//      myList[i] = input.nextDouble();
//    }
//
//    for (int i = 0; i < myList.length; i++) {
//      System.out.print(myList[i] + " ");     //print輸出不換行; printf輸出會換行
//    }

        for (int i = 0; i < myList.length; i++) {
            myList[i] = Math.random() * 100;
            System.out.print(myList[i] + " ");     //print輸出不換行; println輸出會換行
        }
//    System.out.println(myList); //double不能直接輸出，要用for輸出，char才能直接輸出

    }
}
