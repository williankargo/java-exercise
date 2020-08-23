package demo1;

public class math {

    public static void main(String[] args) {
        int a = 10, b = 5;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a / b);
        System.out.println(a * b);
        System.out.println(a % b);
        System.out.println("==========");
        double d1 = 35.0D, d2 = 5.0D;
        System.out.println(d1 + d2);

        System.out.println(7 / -3);

        int i = 10, j = 10;
        int newNum = 10 * i++;      //後置後做
        System.out.println("newNum:" + newNum);
        System.out.println("i:" + i);

        int newNum1 = 10 * ++j;  //前置先做
        System.out.println("newNum1:" + newNum1);
        System.out.println("j:" + j);

        double x = 1.0;
        double y = 5.0;
        double z = x-- + (++y);  //()first do++, and 1+6=7=z, and 1-1=0=x

        System.out.println("y=" + y);
        System.out.println("z=" + z);
        System.out.println("x=" + x);
        System.out.printf("%4.3f", z);
    }

}
