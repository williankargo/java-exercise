package ErrorDetect;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Integer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean continueInput = true;

        do {
            try {
                System.out.println("Enter an integer: ");
                int number = input.nextInt();        //必須輸入整數
                System.out.println("The number entered is: " + number);
                continueInput = false;
            } catch (InputMismatchException ex) {  //使用系統內自定義的nextInt報錯方法
                System.out.println("Try again, an integer is required.");
                input.next();  //把buffer無法讀入nextInt()的input讀成next(), 以免重複loop
            }
        } while (continueInput);
    }
}
