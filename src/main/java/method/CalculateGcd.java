package method;

import java.util.Scanner;


public class CalculateGcd {

//main method

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first integer:");
        int n1 = input.nextInt();

        System.out.println("Enter second integer:");
        int n2 = input.nextInt();

        System.out.println("The greatest common divisor for " + n1 +
                " and " + n2 + " is " + gcd(n1, n2));
    }

    //gcd method return values
    public static int gcd(int n1, int n2) {
        int gcd = 1; //Initial gcd set to 1
        int k = 1; //Possible gcd set to 1

        while (k <= n1 && k <= n2) {
            if (n1 % k == 0 && n2 % k == 0) {
                gcd = k;
            }
            k++;
        }
        return gcd;
    }
}
