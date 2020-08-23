package StreamDemo;

import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamReduce {
    public static void main(String[] args) {
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};

        //1
        System.out.println("The values are: ");
        IntStream.of(values).forEach(e -> System.out.print(e + " "));

        //2
        System.out.print("\nThe result of multiplying all value is ");
        Integer ans = IntStream.of(values).parallel().reduce(1, //單位元素
                (e1, e2) -> e1 * e2);
        //(a, b) -> a * b);
        System.out.println(ans);
        //reduce旁的identity放單位元素(運算上不影響結果的值)，加法的單位元素是0，乘法的單位元素是1

        //3
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Integer lengthSum = stream.parallel().reduce(0, //單位元素
                (sum, str) -> sum + str.length(),      //累加器
                (a, b) -> a + b);                      //部分和 拼接器，執行parallel()會用到
        System.out.println(lengthSum);


        //4
        System.out.print("\nThe value are " + IntStream.of(values).mapToObj(e -> e + "")
                .reduce((e1, e2) -> e1 + ", " + e2).get());

        //5
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George"};
        System.out.print("\nThe names are: " + Stream.of(names).reduce((x, y) -> x + ", " + y).get());
        //todo: 只有數字運算才需要用到identity
        //todo: 數字運算不需要用到get()

        //6
        System.out.print("\nConcat name: " + Stream.of(names).reduce((x, y) -> x + y).get());

        //7
        System.out.print("\nTotal number of characters: " + Stream.of(names)
                .reduce((x, y) -> x + y).get().length());

    }
}
