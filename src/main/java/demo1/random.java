package demo1;

import java.util.Scanner;

public class random {

    public static void main(String[] args) {
        int number1 = (int) (Math.random() * 10); //random value:0.0<=d,1.0
        int number2 = (int) (Math.random() * 10);

        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }
        System.out.println("What is " + number1 + " - " + number2 + " ?");

        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        if (number1 - number2 == answer) {
            System.out.println("You are correct!");
        } else {
            System.out.println("Your answer is wrong!");
            System.out.println("Correct answer is" + (number1 - number2));
        }
    }

}
