package objectAndClass;


public class objectandclass {   //只能有一個public

    //main method
    //(1)靜態方法，可直接調用：Math.random(); 且static variable是共享的，都一樣
    public static void main(String[] args) {  //3個對象class1, class2, class3
        //create a circle with radius 1
        SimpleCircle circle1 = new SimpleCircle();  //變量circle1使用class SimpleCircle，new激活構造方法,產生對象，賦值給circle1
        System.out.println(new SimpleCircle().getArea());//也可以創造對象但不賦值給變量，為匿名對象

        System.out.println("The area of the circle of radius " + circle1.radius + " is "
                + circle1.getArea());
        circle1.egg = 99;

        //create a circle with radius 25
        SimpleCircle circle2 = new SimpleCircle(25);
        System.out.println("The area of the circle of radius " + circle2.radius + " is "
                + circle2.getArea());
        circle2.egg = 100;

        //create a circle with radius 125
        SimpleCircle circle3 = new SimpleCircle(125);
        System.out.println("The area of the circle of radius " + circle3.radius + " is "
                + circle3.getArea() + ", and the perimeter is " + circle3.getPerimeter());
        circle3.egg = 200;
        System.out.println(circle1.egg);  //可發現static variable是共享的
        System.out.println(circle2.egg);
        System.out.println(SimpleCircle.egg); //而且可以用class來引用，不需要物件

        //modify circle radius
        circle2.radius = 100;// or circle2.setRadius(100)
        System.out.println("The area of the circle of radius " + circle2.radius + " is "
                + circle2.getArea());

        //equals example
        SimpleCircle test1 = new SimpleCircle(2.2);
        SimpleCircle test2 = new SimpleCircle(2.3);
        System.out.println(test1.equals(test2));  //false

    }
}

//(2)實例方法，需用特殊方法啟動：SimpleCircle circle = new SimpleCircle();
class SimpleCircle {  //類

    //data field
    double radius;
    double testToString = 0.5;
    static int egg = 88;
    final int finalExample = 88;  //final(1)variable,不可被外部修改(2)class,不可被繼承(3)method,不可被override

    //define the circle class with two constructors,用來初始化對象
    //可不定義構造方法，java會自己創造一個無參數構造方法

    SimpleCircle() { //構造方法需要與類名一樣，前面不用加type
        radius = 1;
    }

    SimpleCircle(double newRadius) {
        radius = newRadius;
    }

    //以下為method
    double getArea() {
        return radius * radius * Math.PI;
    }

    double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    void setRadius(double newRadius) {
        radius = newRadius;
    }

    @Override  //一般無特別寫extend, 都是extend Object()
    public String toString() {  //使用generator的toString()方法, 可自動生成以下功能
        return "SimpleCircle{" +
                "radius=" + radius +
                ", testToString=" + testToString +
                '}';
    }

    @Override //equals example (IDE重定義Object的equal)
    public boolean equals(Object o) {
        if (this == o) {                               //同object
            return true;
        }
        if (o == null || getClass() != o.getClass()) { //無object or class不一樣
            return false;
        }
        SimpleCircle test = (SimpleCircle) o;          //class一樣，有兩個object
        return Double.compare(test.radius, radius) == 0;
    }
}

