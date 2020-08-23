package objectAndClass;

public class CircleWithStaticMembers {

    //1.data field
    private double radius;  //如果沒有說明隱私權，默認為package
    private static int numberOfObjects = 0;   //靜態變量，共用的  //private只能在此class被修改

    //2.constructor
    public CircleWithStaticMembers() {  //無參
        radius = 1.0;
        numberOfObjects++;
    }

    public CircleWithStaticMembers(double newRadius) {  //有參
        radius = newRadius;
        numberOfObjects++;
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
    public static int getNumberOfObjects() {   //靜態方法
        //getArea();  靜態方法不可以訪問實例方法與變量，但是實例可以訪問靜態
        return numberOfObjects;
    }

    //setter, 修改numberOfObjects
    public static void setNumberOfObjects(int numberOfObjects) {
        if (numberOfObjects >= 0) {
            CircleWithStaticMembers.numberOfObjects = numberOfObjects;
        }
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }


}
