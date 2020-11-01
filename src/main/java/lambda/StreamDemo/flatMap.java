package lambda.StreamDemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// flatMap v.s. Map
// 1 對 多      1 對 1

public class flatMap {

    public static void main(String[] args) throws IOException {
        FlatMapDemo1();
    }


    public static void FlatMapDemo1() {
        class Inner {
            String name;

            Inner(String name) {
                this.name = name;
            }

            public String toString() {
                return this.name;
            }
        }
        class Outer {
            String name;

            Outer(String name) {
                this.name = name;
            }

            List<Inner> inners = new ArrayList<>();

            public String toString() {
                return this.name;
            }
        }

        List<Outer> outers = new ArrayList<>();

        // 在 outers裡建立 3 個  Outer
        IntStream
                .range(1, 4)
                .forEach(i -> outers.add(new Outer("Outer_" + i)));

        // 在 outers 裡的每個 inners 裡各建立 3 個 Inner
        outers.forEach(
                outer -> IntStream
                                .range(1, 4)
                                .forEach(
                                        i -> outer.inners.
                                                add(new Inner("Inner_" + i + " , from <" + outer.name + ">"))
                                )
        );

        long memberQuantity =
                outers.stream()
                        //.peek(System.out::println)
                        //.map(outer -> outer.inners.stream())
                        .flatMap(outer -> outer.inners.stream())
                        .peek(System.out::println)
                        .count();
    }
}