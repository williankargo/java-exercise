package ErrorDetect;

import java.util.Scanner;

public class Division {

    public static int quotient(int number1, int number2) {
        if (number2 == 0) {//自定義例外，也可以不要有這一行if
            throw new ArithmeticException("除數不可為0"); //(1)拋出一個ArithmeticException物件, 可在後面自定義訊息
        }//throw:拋出異常、throws聲明異常(必檢異常才要寫)
        return number1 / number2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();

        try {
            int result = quotient(number1, number2);
            System.out.println(number1 + " / " + number2 + " is " + result);
        } catch (ArithmeticException ex) {     //(2)接到一個ArithmeticException物件，並執行以下
            System.out.println("例外原因：" + ex.getMessage());
            System.out.println(ex);//=ex.toString()
            System.out.println(ex.getStackTrace());
        } finally {
            System.out.println("我一定會被執行！");
        }
        System.out.println("Execution continues...");
    }
//    double number3 = number1/number2;
//    System.out.println(number3);
//
//
//  }
}
