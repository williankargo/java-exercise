package Test.OOD.hw3;

import java.util.Scanner;

abstract class parent {

    protected int n;

    public parent(int n) {
        this.n = n;
    }

    //TODO: 回傳一個array
    public abstract int[][] method();

    public void show(int a[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
    }
}

class hw03_1 extends parent {
    public hw03_1(int N) {
        super(N);
    }

    public int[][] method() {
        int[][] m = new int[super.n][super.n];
        m[0][0] = 1;
        m[super.n - 1][super.n - 1] = super.n * super.n;
        //設定第一列的數字
        for (int j = 1; j < m.length; j++) {
            m[0][j] = m[0][j - 1] + j;
        }
        //設定第N行的數字
        for (int i = super.n - 2; i > 0; i--) {
            m[i][super.n - 1] = m[i + 1][super.n - 1] - (super.n - 2 - i + 2);
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < m.length - 1; j++) {
                m[i][j] = m[i - 1][j + 1] + 1;
            }
        }
        return m;
    }
}


class hw03_2 extends parent {

    public hw03_2(int n) {
        super(n);
    }

    @Override
    public int[][] method() throws ArrayIndexOutOfBoundsException {
        int[][] m = new int[super.n][super.n];
        //設定MATRIX中心3*3的數值
        m[(super.n - 1) / 2][(super.n - 1) / 2] = 1;
        m[(super.n - 1) / 2][(super.n - 1) / 2 + 1] = 2;
        m[(super.n - 1) / 2 + 1][(super.n - 1) / 2 + 1] = 3;
        m[(super.n - 1) / 2 + 1][(super.n - 1) / 2] = 4;
        m[(super.n - 1) / 2 + 1][(super.n - 1) / 2 - 1] = 5;
        m[(super.n - 1) / 2][(super.n - 1) / 2 - 1] = 6;
        m[(super.n - 1) / 2 - 1][(super.n - 1) / 2 - 1] = 7;
        m[(super.n - 1) / 2 - 1][(super.n - 1) / 2] = 8;
        m[(super.n - 1) / 2 - 1][(super.n - 1) / 2 + 1] = 9;
        //設定MATRIX對角線的數值與交點為中心元素的行與列的數值
        for (int i = 1; i < (m.length - 1) / 2; i++) {
            for (int j = 1; j < (m.length - 1) / 2; j++) {
                m[(super.n - 1) / 2][(super.n - 1) / 2 + 1 + j] = m[(super.n - 1) / 2][(super.n - 1) / 2 + j] + 8 * j + 1;
                m[(super.n - 1) / 2][(super.n - 1) / 2 - 1 - j] = m[(super.n - 1) / 2][(super.n - 1) / 2 - j] + 8 * j + 5;
                m[(super.n - 1) / 2 + 1 + i][(super.n - 1) / 2] = m[(super.n - 1) / 2 + i][(super.n - 1) / 2] + 8 * i + 3;
                m[(super.n - 1) / 2 - 1 - i][(super.n - 1) / 2] = m[(super.n - 1) / 2 - i][(super.n - 1) / 2] + 8 * i + 7;
                if (i == j) {
                    m[(super.n - 1) / 2 + 1 + i][(super.n - 1) / 2 + 1 + j] = m[(super.n - 1) / 2 + i][(super.n - 1) / 2 + j] + 8 * i + 2;
                    m[(super.n - 1) / 2 - 1 - i][(super.n - 1) / 2 - 1 - j] = m[(super.n - 1) / 2 - i][(super.n - 1) / 2 - j] + 8 * i + 6;
                    m[(super.n - 1) / 2 + 1 + i][(super.n - 1) / 2 - 1 - j] = m[(super.n - 1) / 2 + i][(super.n - 1) / 2 - j] + 8 * i + 4;
                    m[(super.n - 1) / 2 - 1 - i][(super.n - 1) / 2 + 1 + j] = m[(super.n - 1) / 2 - i][(super.n - 1) / 2 + j] + 8 * i + 8;
                }
            }
        }
        //處理中心3*3部分以上的區塊
        for (int i = 0; i < (m.length - 1) / 2 - 1; i++) {
            for (int j = 0; j < m.length; j++) {
                if (i == 0 && j != 0) m[i][j] = m[i][j - 1] + 1;
                else if (i != 0 && j > i && j <= m.length - 1) m[i][j] = m[i][j - 1] + 1;
            }
        }
        //處理中心3*3部分左方的區塊
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < (m.length - 1) / 2 - 1; j++) {
                if (j == 0 && i != m.length - 1) m[i + 1][j] = m[i][j] - 1;
                else if (j != 0 && i >= j && i < m.length - 1 - j) m[i + 1][j] = m[i][j] - 1;
            }
        }
        //處理中心3*3部分右方的區塊
        for (int i = m.length - 1; i >= (m.length - 1) / 2 - 1; i--) {
            for (int j = m.length - 1; j > (m.length - 1) / 2 + 1; j--) {
                if (j == m.length - 1) m[i - 1][j] = m[i][j] - 1;
                else if (i <= j && i > m.length - j) m[i - 1][j] = m[i][j] - 1;
            }
        }
        //處理中心3*3部分以下的區塊
        for (int i = m.length - 1; i > (m.length - 1) / 2 + 1; i--) {
            for (int j = m.length - 1; j > 0; j--) {
                if (i == m.length - 1) m[i][j - 1] = m[i][j] + 1;
                else if (j >= m.length - i && j <= i) m[i][j - 1] = m[i][j] + 1;
            }
        }
        return m;
    }
}

public class hw03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("輸入N值 ");
        int N = sc.nextInt();  //N is an odd number

        hw03_1 matrix = new hw03_1(N);
        int[][] b = matrix.method();
        matrix.show(b);

        System.out.println();

        hw03_2 m = new hw03_2(N);
        int[][] c = m.method();
        m.show(c);
    }
}