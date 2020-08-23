package Test.OOD.quiz0526;

public class quiz2 {

    public static void main(String[] args) {
        CCircle cir = new CCircle(8, 6, 2);
        cir.showData();
    }

}

interface iVolume {

    public void showData();

    public double vol();
}

abstract class CSphere implements iVolume {

    final double PI = 3.14;
    protected int x;
    protected int y;
}

class CCircle extends CSphere {

    int radius;

    CCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void showData() {
        System.out.println("center:" + "(" + x + "," + y + ")");
        System.out.println("radius:" + radius);
        System.out.println("volumn:" + this.vol());
    }

    @Override
    public double vol() {
        return PI * Math.pow(this.radius, 3) * 4 / 3;
    }
}