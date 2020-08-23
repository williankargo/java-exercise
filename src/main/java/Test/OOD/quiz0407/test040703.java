package Test.OOD.quiz0407;

import java.util.Scanner;

public class test040703 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Shape example = new Shape();
        System.out.println("Please enter the width and heoght of a rectangle: ");
        int a = in.nextInt();
        double b = in.nextDouble();
        example.set_arg(a, b);
        example.show_area();

        Shape example2 = new Shape();
        System.out.println("Please enter the side of a square: ");
        int c = in.nextInt();
        example.set_arg2(c, c);
        example.show_area();

        Shape example3 = new Shape();
        System.out.println("Please enter the radius and pi of a square: ");
        int e = in.nextInt();
        double d = in.nextDouble();
        example3.set_arg(e, d);
        example3.show_area();

    }
}

class Shape {

    private double arg1;
    private double arg2;

    void show_area() {
        double answer = arg1 * arg2;
        System.out.println("area = " + answer);
    }

    void set_arg2(int a, int b) {
        arg1 = a;
        arg2 = b;
    }

    void set_arg(int a, double b) {
        arg1 = a;
        arg2 = b;
    }

    private void area(int e, double d) {
        double answer2 = e * d;
        System.out.println("area = " + answer2);
    }
}