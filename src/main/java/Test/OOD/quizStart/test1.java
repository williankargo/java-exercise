package Test.OOD.quizStart;

import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence = "wow";
        System.out.println("位移量：");
        int move = input.nextInt();

        while (!sentence.equals("Exit")) {
            if (sentence.equals("Exit")) {
                break;
            }
            System.out.println("輸入句子：");
            sentence = input.next();

            System.out.println("輸出句子：");
            moveChar(sentence, move);
            System.out.println();
        }
    }

    public static void moveChar(String str, int move) {

        String foo = str;
        String bar = "";

        for (char c : foo.toCharArray()) {
            bar += Character.toString((char) (((c - 'a' + move) % 26) + 'a'));
        }
        System.out.println(bar);
    }

//  public static void moveChar2(String str, int more){
//    String[] example = {}
//  }
//
}
