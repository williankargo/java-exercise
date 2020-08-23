package circle;

import java.util.Scanner;

public class DoWhile {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int data;
        int sum = 0;

        do {
            System.out.println("enter an integer:");
            data = input.nextInt();
            sum += data;
        } while (data != 0);  //data!=0就繼續執行
        System.out.println(sum);
    }

}
