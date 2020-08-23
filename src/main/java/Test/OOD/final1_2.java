package Test.OOD;

import java.util.Scanner;

public class final1_2 {

    public static void main(String[] args) {

        // get number from user
        System.out.print("please enter a number: ");
        Scanner keyboard = new Scanner(System.in);
        try {
            int num = keyboard.nextInt();
            RunPrime runprime1 = new RunPrime(num);

            runprime1.start();
            Thread.yield();

            runprime1.SmallerPrimeNumbers();
        } catch (Exception e) {
            System.out.println("please enter integer!!!");
            ;
        }
    }
}

class RunPrime extends Thread {

    private int given_number;

    RunPrime(int n) {
        given_number = n;
    }

    public void SmallerPrimeNumbers() {
        int count = 0;
        for (int i = 0; i <= given_number; i++) {
            if (CheckPrime(i)) {
                if (i != 0 && i != 1) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static boolean CheckPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}