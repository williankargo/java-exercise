package dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();  //ArrayList包含了array的優缺點：查找容易、插入難
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add(0, "a1");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        arrayList.remove(0); //delete
        System.out.println(arrayList);

        showGreaterThan100();

    }

    private static void showGreaterThan100() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(101);
        integerList.add(55);
        integerList.add(200);
        integerList.add(333);

        //lambada method
        List c1 = integerList.stream().filter(item -> item > 100).collect(Collectors.toList());
        System.out.println(c1);
    }
}


