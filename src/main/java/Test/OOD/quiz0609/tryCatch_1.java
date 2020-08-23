package Test.OOD.quiz0609;

public class tryCatch_1 {

    public static void main(String[] args) {
        int num = 12;
        int den[] = {12, 0, 3, 0, 0, 4};

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("ans = " + num / den[i]);
            } catch (ArithmeticException e) {
                System.out.println(e);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }
        }
    }
}
