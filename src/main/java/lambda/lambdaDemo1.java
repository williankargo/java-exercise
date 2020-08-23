package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//一種函數式的編程方法:把函數當成參數傳遞給函數
public class lambdaDemo1 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 2);
        map.put(3, 3);

        //traditional method
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key =" + entry.getKey() + ", Value=" + entry.getValue());
        }

        System.out.println("========================");

        //lambada method
        map.forEach((k, v) -> {   //forEach()裡的東西是是@FunctionalInterface，所以可以用lb來實現
            System.out.println("Key=" + k);
            System.out.println("Value=" + v);

        });

        // lambada example 2
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(k -> System.out.println(k));

        // lambada example 3
        //old
        new Thread(new Runnable() {  //Runnable()是@FunctionalInterface(一個interface只能有一個方法)，而lb就是此類的實現類
            @Override
            public void run() {
                System.out.println(" Hello World!");
            }
        });

        //new
        new Thread(() -> {
            System.out.println("Hello World!");
        });

    }
}

//https://github.com/williankargo/java-python-R-codes/blob/master/LBdemo.java
