package Test.OOD.quiz0505;


public class test2 {

    public static void main(String[] args) {
        Square square = new Square(5, "Square");
        Rectangle rect = new Rectangle(4, 5, "Rectangle");
        Circle circle = new Circle(5, "Circle");

        square.show();
        rect.show();
        circle.show();
    }
}

class Shape {

    private double area;
    private double perimeter;
    private String shapeName;

    Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void show() {
        System.out.printf("Shape name: %s, area: %f, perimeter: %f\n", shapeName, area, perimeter);
    }
}

class Square extends Shape {

    private double width;

    Square(double width, String shapeName) {  //在constructor設定三個父類變數
        super(shapeName);
        this.width = width;
        super.setArea(calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    public double calculateArea() {
        double area = this.width * this.width;
        return area;
    }

    public double calculatePerimeter() {
        double perimeter = width * 4;
        return perimeter;
    }
}

class Rectangle extends Shape {

    private double length;
    private double width;

    Rectangle(double length, double width, String shapeName) {
        super(shapeName);
        this.length = length;
        this.width = width;
        super.setArea(calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    public double calculateArea() {
        double area = width * length;
        return area;
    }

    public double calculatePerimeter() {
        double perimeter = (width + length) * 2;
        return perimeter;
    }
}

class Circle extends Shape {

    private double radius;
    private final double pi = Math.PI;

    Circle(double radius, String shapeName) {
        super(shapeName);
        this.radius = radius;
        super.setArea(calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    public double calculateArea() {
        double area = radius * radius * pi;
        return area;
    }

    public double calculatePerimeter() {
        double perimater = (2 * radius) * pi;
        return perimater;
    }
}

