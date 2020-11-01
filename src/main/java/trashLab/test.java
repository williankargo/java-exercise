package trashLab;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        Function<Integer, Integer> mapper = n -> 2 * n;
        Stream<Integer> mapResult = Stream.of(1,2,3,4).map(mapper);
        Object[] arr = mapResult.toArray();
        List<Object> list = Arrays.asList(arr);
        System.out.println(list);
    }
}


