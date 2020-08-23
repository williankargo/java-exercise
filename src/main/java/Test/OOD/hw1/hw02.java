package Test.OOD.hw1;

import java.util.Arrays;
import java.util.Scanner;

public class hw02 {

    public static void main(String[] args) {
        System.out.println("輸入3個數字會計算最大公因數與最小公倍數");
        System.out.println("輸入4個數字會計算代入方程式Q的最大值");
        System.out.println("輸入5個數字會計算標準差");
        Scanner input = new Scanner(System.in);
        System.out.println("好的，那請你輸入數字，以空白鍵隔開：");

        //輸入多個值，以空白鍵隔開產生array的方法
        String S = input.nextLine();
        String[] strary = S.split(" "); //line to array
        int[] intary = new int[strary.length];
        for (int i = 0; i < strary.length; i++) {
            intary[i] = Integer.parseInt(strary[i]);//str to int
        }

        MultiFunction example = new MultiFunction();
        if (intary.length == 3) {
            example.show(intary[0], intary[1], intary[2]);
        } else if (intary.length == 4) {
            example.show(intary[0], intary[1], intary[2], intary[3]);
        } else if (intary.length == 5) {
            example.show(intary[0], intary[1], intary[2], intary[3], intary[4]);
        } else {
            System.out.println("把題目看清楚，重新輸入！");
        }
    }
}

class MultiFunction {

    void show(int x1, int x2, int x3) {
        int gcdans = gcd(x1, x2, x3);
        System.out.println("gcd = " + gcdans);

        int lcmans = lcm1(lcm(x1, x2), x3);
        System.out.println("lcm =  " + lcmans);
    }

    int gcd(int a, int b, int c) {
        int limit = Math.min(a, b);
        limit = Math.min(limit, c);
        for (int n = limit; n > 1; n--) {
            if ((a % n == 0) && (b % n == 0) && (c % n == 0)) {
                return n;
            }
        }
        return 1;
    }

    int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }

    int lcm1(int m, int n) {
        return m * n / gcd(m, n);
    }

    int gcd(int m, int n) {
        if (n != 0) {
            return gcd(n, m % n);
        } else {
            return m;
        }
    }

    void show(int x1, int x2, int x3, int x4) {
        int Xarray[] = {x1, x2, x3, x4};
        Arrays.sort(Xarray); //由小排到大

        //正的兩項，放前兩大值比大小，擇大
        double part1 = Math.pow((Xarray[3]), (double) 3 / 2); //次方默認為int, 如果使用double要特別轉換
        double part2 = 5 * Xarray[2];
        double ans1 = part1 + part2;


        double part11 = Math.pow((Xarray[2]), (double) 3 / 2);
        double part22 = 5 * Xarray[3];
        double ans2 = part11 + part22;
        double max;
        if (ans1 > ans2) {
            max = ans1;
        } else {
            max = ans2;
        }

        //負的兩項，放後兩小值比大小，擇大
        double part3 = Math.pow((Xarray[0]), 2) * (-2);
        double part4 = (-4) * Xarray[1];
        double ans3 = part3 + part4;

        double part33 = Math.pow((Xarray[1]), 2) * (-2);
        double part44 = (-4) * Xarray[0];
        double ans4 = part33 + part44;
        double max2;
        if (ans3 > ans4) {
            max2 = ans3;
        } else {
            max2 = ans4;
        }

        //相加，答案
        double answer = max + max2;

        System.out.println("Q = " + answer + "(the value is max)");
    }

    void show(int x1, int x2, int x3, int x4, int x5) {
        int Xarray[] = {x1, x2, x3, x4, x5};
        double average = (x1 + x2 + x3 + x4 + x5) / 5;
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            double ans = Math.pow((Xarray[i] - average), 2); //java用來表達次方的方法
            sum = sum + ans;
        }
        double answer = Math.pow((sum / 5), 0.5);
        System.out.println("SD = " + answer);
    }


}
