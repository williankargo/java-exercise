package circle;

import java.util.Scanner;

public class While3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//理解為引入方法
        System.out.println("Enter a number");
        int data = input.nextInt();

        int sum = 0;
        while (data != 0) {
            sum += data;
            System.out.println("enter an integer:");
            data = input.nextInt();  //理解為輸入
        }
        System.out.println(sum);

    }
}
