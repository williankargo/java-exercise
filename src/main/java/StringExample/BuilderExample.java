package StringExample;

import java.util.Scanner;

public class BuilderExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();

        System.out.println("Ignoring non-alphanumeric characters, \nis"  //\n換行
                + s + " a palindrome? " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String s1 = filter(s);
        String s2 = reverse(s1);
        return s2.equals(s1);
    }

    public static String filter(String s) {
        //create a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();  //正式生成物件string
    }

    public static String reverse(String s) {
        //create a StringBuilder
        StringBuilder stringBuilder = new StringBuilder(s);

        stringBuilder.reverse();
        return stringBuilder.toString();  //正式生成物件string
    }
//StringBuilder很好用是因為她裡面有很多已經封裝好的方法
}
