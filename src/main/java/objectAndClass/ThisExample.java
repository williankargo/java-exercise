package objectAndClass;

public class ThisExample {

    //1.data field
    private double radius;  //如果沒有說明隱私權，默認為package
    private static int numberOfObjects = 0;

    //2.constructor
    public ThisExample() {  //無參
        this(66);    //(1)需放在方法最前面 (2)用來引用另一個有參的方法
        radius = 1.0;
        numberOfObjects++;
    }

    public ThisExample(double radius) {  //有參
        this.radius = radius;   //(3)把後面的radius(輸入值)給前面的radius(value field定義的實例參數)
        numberOfObjects++;      //(4)this不能用在static, 只能用在實例變數
    }

    //3.method

    //(1)
    //getter, 取得radius (command+N)
    public double getRadius() {
        return radius;
    }

    //setter, 修改radius
    public void setRadius(double newRadius) {
        radius = (newRadius >= 0) ? newRadius : 0;
    }

    //(2)
    //getter, 取得numberOfObjects
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    //setter, 修改numberOfObjects
    public static void setNumberOfObjects(int numberOfObjects) {
        if (numberOfObjects >= 0) {
            ThisExample.numberOfObjects = numberOfObjects;
        }
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }


}


