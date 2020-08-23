package circle;

public class While {

    public static void main(String[] args) {
        int sum = 0, i = 1;
        while (i < 10) {
            sum = sum + i;
            i++; //不要忘記加加
        }
        System.out.println(sum);
    }
}
