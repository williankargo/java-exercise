package circle;

public class Break {

    public static void main(String[] args) {
        int sum = 0;
        int number = 0;
        while (number < 20) {
            number++;
            sum += number;
            if (sum > 100) {
                break;      //break就直接跳出去，甚至跳出while
            }
        }
        System.out.println("NUM:" + number);
        System.out.println("SUM:" + sum);
    }
}