package objectAndClass;

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {
        Random random1 = new Random(4); //Random放的seed一樣，隨機結果會一樣
        System.out.println("From random1: ");
        for (int i = 0; i < 10; i++) {
            System.out.print((random1.nextInt(3)+1) + " "); //nextInt()隨機生成bound內的Int
        }
        Random random2 = new Random(4);
        System.out.println("\nFrom random2: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(random2.nextInt(1000) + " ");
        }
    }
}
