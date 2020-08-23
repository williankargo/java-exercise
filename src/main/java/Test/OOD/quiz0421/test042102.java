package Test.OOD.quiz0421;

public class test042102 {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        int len = (int) (Math.random() * 10);
        int wid = (int) (Math.random() * 10);
        int radius = (int) (Math.random() * 10);

        shapes[0] = new Shape(len, len);
        shapes[1] = new Shape(len, wid);
        shapes[2] = new Shape(radius);

        //0
        System.out.print("Shape 0:");
        double zeroarea = shapes[0].getArea();
        System.out.println(zeroarea);

        //1
        System.out.print("Shape 1:");
        double onearea = shapes[1].getArea();
        System.out.println(onearea);

        //2
        System.out.print("Shape 2:");
        double twoarea = shapes[2].getArea();
        System.out.println(twoarea);

        //maxarea
        Shape maxArea = new Shape();
        System.out.println("Max area: ");
        maxArea = shapes[0];
        maxArea = maxArea.compare(shapes[1]);
        maxArea = maxArea.compare(shapes[2]);

        System.out.println(maxArea.getArea());
    }
}

class Shape {

    private static double pi = 0;
    private double area = -1;


    Shape() {
        this.area = 0;
    }

    //圓形
    Shape(int radius) {
        setArea(radius);
    }

    //長方形
    Shape(int len, int wid) {
        setArea(len, wid);
    }


    //長方形area
    private void setArea(int len, int wid) {
        this.area = len * wid;
    }

    //圓形area
    private void setArea(int radius) {
        setPI(3.14);
        this.area = radius * radius * pi;
    }

    static void setPI(double pi) {
        Shape.pi = Math.PI;       //在static method內就只能用static variable/靜態方法不可以訪問實例方法與變量，但是實例可以訪問靜態
    }


    double getArea() {
        return area;
    }

    //回傳比較大的面積
    Shape compare(Shape s) {
        if (this.getArea() > s.getArea()) {
            return this;
        } else if (this.getArea() < s.getArea()) {
            return s;
        } else {
            return this;
        }
    }
}
