package trashLab.face;

import java.util.Scanner;

public class quixx {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ans = input.next();
//    String ans = "()";
        isValid(ans);
    }

    static <Stirng> void isValid(String str) {
        // 待匹配的左括號數量
        int left = 0;
        int count = 0;

        String[] words = str.split("");
        for (String c : words) {
//      System.out.println(c);
            if (c.equals("(")) {
                left++;
            } else { // 遇到右括號
                left--;
                count++;
            }
        }

        if (left < 0) {
            System.out.println("NO!");
        } else {
            System.out.println("Yes!");
            System.out.println(count);
        }
    }
}
