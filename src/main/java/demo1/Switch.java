package demo1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a year:");
        int year = input.nextInt();
//switch遇到break就跳出
        switch (year % 12) {
            case 0:
                System.out.println("monkey");
                break;
            case 1:
                System.out.println("rooster");
                break;
            default:
                System.out.println("I don't know!");
        }
    }

}
