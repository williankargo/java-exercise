package circle;

public class Continue {

    public static void main(String[] args) {
        int sum = 0;
        int number = 0;
        while (number < 20) {
            number++;
            if (number == 11 || number == 12) {
                continue;  //跳過這兩個後繼續循環，如果是break是跳出整個while
            }
            sum += number;
        }
        System.out.println("SUM:" + sum);
    }
}
