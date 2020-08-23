package Test.OOD.quizStart;


import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        int k = 0;
        while (k == 0) {
            for (int i = 0; i < 10; i++) {
                String[] prizes = new String[]{"SSR", "SR", "R"};

                String prize;
                int j = (int) (Math.random() * 100);
                if (j == 0) {
                    prize = prizes[0];
                } else if (j >= 1 && j <= 12) {
                    prize = prizes[1];
                } else {
                    prize = prizes[2];
                }
                System.out.print(prize + " ");
            }
            promptEnterKey();
        }
    }

    public static void promptEnterKey() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}

