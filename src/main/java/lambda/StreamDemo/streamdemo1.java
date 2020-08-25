package lambda.StreamDemo;

import java.util.Arrays;
import java.util.stream.Stream;

public class streamdemo1 {

    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Mike", "Kim", "Jen"};

        // Stream/source/限定個數4/按字母排列/lb打印
        Stream.of(names).limit(4).sorted().forEach(e -> System.out.print(e + " "));

        System.out.println();
        Stream.of(names).skip(2).sorted((e1, e2) -> e1.compareToIgnoreCase(e2))  //忽略大小寫method1
                .forEach(e -> System.out.print(e + " "));

        System.out.println();
        Stream.of(names).skip(2).sorted(String::compareToIgnoreCase)  //忽略大小寫method2
                .forEach(e -> System.out.print(e + " "));

        System.out.println("Any Match");
        System.out.println(Stream.of(names).anyMatch(e -> e.equals("Peter")));

        System.out.println("All Match");
        System.out.println(Stream.of(names).allMatch(e -> Character.isUpperCase(e.charAt(0))));

        System.out.println();
        System.out.println(Stream.of(names).noneMatch(e -> e.startsWith("Ko")));

        System.out.println();
        System.out.println(Stream.of(names).map(e -> e.toUpperCase()).distinct().count());

        System.out.println();
        Object[] array = Stream.of(names).map(String::toLowerCase).toArray();
        System.out.println(Arrays.toString(array));
    }
}

//https://objcoding.com/2019/03/04/lambda/
