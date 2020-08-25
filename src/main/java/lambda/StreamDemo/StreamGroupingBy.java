package lambda.StreamDemo;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamGroupingBy {
    public static void main(String[] args) {

        //1
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "Apple"};
        Map<String, Long> map1 = Stream.of(names).map(e -> e.toUpperCase())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map1);


        //2
        Map<Character, Long> map2 = Stream.of(names).collect(Collectors
                .groupingBy(e -> e.charAt(0),
                        TreeMap::new,   //保存在treemap中，輸出時會按字母排序
                        Collectors.counting()));
        System.out.println(map2);


        //3
        int[] values = {2, 3, 4, 1, 2, 3, 2, 3, 4, 5, 1, 421};
        IntStream.of(values).mapToObj(e -> e).collect(Collectors
                .groupingBy(e -> e, Collectors.counting())).
                forEach((k, v) -> System.out.println(k + " occurs " + v + (v > 1 ? " times " : " times ")));

        //4
        MyStudents[] students = {new MyStudents("John", "Lu", "CS", 18, 78),
                new MyStudents("Susan", "Yao", "Math", 31, 86),
                new MyStudents("Kim", "Johnson", "CS", 30, 78.1)
        };

        System.out.printf("%10s%10s\n", "Department", "Average");
        Stream.of(students).collect(Collectors
                .groupingBy(MyStudents::getMajor, Collectors.averagingDouble(MyStudents::getScore)))
                .forEach((k, v) -> System.out.printf("%10s%10.2f\n", k, v));

    }
}
