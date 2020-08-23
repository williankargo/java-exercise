package Test.OOD;


interface iVolume2 {

    public void showData();

    public double vol();
}

//TODO
abstract class CSphere2 implements iVolume2 {

    final double PI = 3.14;
    protected int x;
    protected int y;
    protected int r;

    public void showData() {
        System.out.println("center:" + "(" + x + "," + y + ")");
        System.out.println("radius: " + r);
        System.out.println("volume: " + this.vol());
    }

    public double vol() {
        double ans = PI * Math.pow(this.r, 3) * 4 / 3;
        ;
        return ans;
    }
}

//TODO: don't define show(), vol() here
class CCircle2 extends CSphere2 {

    CCircle2(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

}

public class final4 {

    public static void main(String[] args) {
        CCircle2 cir = new CCircle2(8, 6, 2);
        cir.showData();
    }
}
