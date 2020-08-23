package StreamDemo;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Intstreamdemo {

    public static void main(String[] args) {

        //1
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};
        System.out.println(IntStream.of(values).distinct().filter(e -> e > 3 && e % 2 == 0).average().getAsDouble());
        System.out.println(Stream.of(values).map(e -> e + "") //先變成字符串, e是全部的東西
                .mapToInt(e -> e.length()).sum());

        //2
        System.out.println(IntStream.of(values).limit(4).sum());

        //3 Stats
        IntSummaryStatistics stats = IntStream.of(values).summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        //...

        //4
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen"};
        System.out.println(Stream.of(names).mapToInt(e -> e.length()).sum());


    }


}
