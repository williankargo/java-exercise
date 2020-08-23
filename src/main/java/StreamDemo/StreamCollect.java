package StreamDemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {

    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen", "George", "Alan", "Stacy"};

        //1
        System.out.println("The number of characters for all names: " +
                Stream.of(names).collect(StringBuilder::new,  //目標容器
                        StringBuilder::append,                //累加器
                        StringBuilder::append).length());     //parallel間的部分內容如何合併

        //2
        //method1(hard)
        List<String> list = Stream.of(names).collect(ArrayList::new,
                ArrayList::add,
                ArrayList::addAll);
        System.out.println(list);

        //method2(simple)
        list = Stream.of(names).collect(Collectors.toList());
        System.out.println(list);

        //3 Set
        Set<String> set = Stream.of(names).map(e -> e.toUpperCase()).collect(Collectors.toSet());
        System.out.println(set);

        //4 Map                                                            // = Funciton.identity()
        Map<String, Integer> map = Stream.of(names).collect(Collectors.toMap(e -> e, e -> e.length()));
        System.out.println(map);

        //5 Stats
        System.out.println("The total number of characters is " +
                Stream.of(names).
                        collect(Collectors.summingInt(e -> e.length())));

        IntSummaryStatistics stats = Stream.of(names)
                .collect(Collectors.summarizingInt(e -> e.length()));  //summarizingInt和summingInt 不一樣！
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("AVG: " + stats.getAverage());
    }
}
