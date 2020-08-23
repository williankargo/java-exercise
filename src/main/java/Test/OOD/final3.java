package Test.OOD;

interface iVolume {

    public void showData();

    public double vol();
}

abstract class CSphere implements iVolume {

    final double PI = 3.14;
    protected int x;
    protected int y;
}

//TODO
class CCircle extends CSphere {

    int r;

    CCircle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void showData() {
        System.out.println("center:" + "(" + x + "," + y + ")");
        System.out.println("radius: " + r);
        System.out.println("volume: " + this.vol());
    }

    @Override
    public double vol() {
        double ans = PI * Math.pow(this.r, 3) * 4 / 3;
        ;
        return ans;
    }
}
/////

public class final3 {

    public static void main(String[] args) {
        CCircle cir = new CCircle(8, 6, 2);
        cir.showData();
    }
}
