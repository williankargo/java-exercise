package Test.OOD.midterm;

public class quiz1 {

    public static void main(String[] args) {
        CData obj = new CData(3, 8);
        obj.area();
    }
}

class CShape {

    int CShapenouse;

    CShape() {
        System.out.println("CShape is created.");
    }

}

class CTriangle extends CShape {

    protected int base;
    protected int height;

    CTriangle() {
        System.out.println("CTriangle is create.");
    }

    protected void show() {
        System.out.println("base= " + base + ", height= " + height);
    }
}

class CData extends CTriangle {

    double area;

    CData(int a, int b) {
        System.out.println("CData is created.");
        super.base = a;
        super.height = b;
        this.area = a * b / 2;
    }

    void area() {
        this.show();
    }

    @Override
    public void show() {
        System.out.println("base= " + base + ", height= " + height + ", area= " + area + ".");
    }
}