package demo1;

import java.util.Scanner;

public class Next {

    public static void main(String[] args) {

        //next()只能存取單詞
        System.out.println("Enter words:");
        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        String s2 = input.next();
        String s3 = input.next();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        //nextLine()可以存取句子
        System.out.println("Enter words:");
        Scanner input2 = new Scanner(System.in);
        String s = input2.nextLine();
        System.out.println(s);
    }


}
