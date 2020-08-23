package demo1;

public class epsilon {

    public static void main(String[] args) {
        double x = 1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1;
        System.out.println(x);
        System.out.println(x == 0.5);

        //epsilon

        final double EPSILON = 1E-14;
        if (Math.abs(x - 0.5) < EPSILON) { //引用Math方法,abs是絕對值
            System.out.println("true");
        }
    }

}
