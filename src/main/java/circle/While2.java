package circle;

import java.util.Scanner;

public class While2 {

    public static void main(String[] args) {
        int number = (int) Math.random() * 101; //0.1<=random<1

        System.out.println("Guess a number between 0~100:");

        int guess = -1;
        while (guess != number) {   //循環條件最後再打
            System.out.println("Enter your guess:");
            Scanner input = new Scanner(System.in);
            guess = input.nextInt();
            if (guess == number) {
                System.out.println("you are smart!");
            } else if (guess > number) {
                System.out.println("too big!");
            } else {
                System.out.println("you are too small!");
            }
        }
    }

}
