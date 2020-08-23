package demo1;

import java.util.Scanner;

public class if_else {

    public static void main(String[] args) {
        //create a Scanner object
        Scanner input = new Scanner(System.in);

        //prompt the user to enter a radius
        System.out.println("Enter a number for radius:");
        double radius = input.nextDouble();

        if (radius < 0) {
            System.out.println("Enter wrong number, please retype again!");
        } else {
            //Computer area
            double area = radius * radius * 3.14159;

            //Display result
            System.out.println("The area for the circle of radius " + radius + " is " + area);
        }

    }

}
