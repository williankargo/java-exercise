package Test.OOD.quiz0609;

public class ifElse {

    public static void main(String[] args) {
        int num = 12;
        int den[] = {12, 0, 3, 0, 0, 4};

        for (int i = 0; i < 10; i++) {
            if (i > (den.length - 1)) {
                System.out.println("Array index out of bound exception!");
                continue;
            } else if (den[i] == 0) {
                System.out.println("Divide by zero exception!");
                continue;
            } else {
                System.out.println("ans = " + num / den[i]);
            }
        }
    }
}
