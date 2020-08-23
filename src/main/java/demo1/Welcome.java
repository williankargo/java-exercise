package demo1;

/*
fuck you lah!
 */


public class Welcome {

    public static void main(String[] args) {//psvm
        int a = 2;
        int b = 4;

        int sum = a + b;
        System.out.println("sum=" + sum);

        int dis = a - b;
        System.out.println("dis=" + dis);

        System.out.println((int) 5.0 / 2); //強制類型轉換
        System.out.println(5.0 / 2);//拓寬類型

        final float a1 = 1.0f; //常量，只能賦值一次
        float a2 = 3.0f;

        System.out.println(a1 + a2);

        System.out.println(5 % 2); //取模操作
    }
}
