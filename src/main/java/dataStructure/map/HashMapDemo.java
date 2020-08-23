package dataStructure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        //HashMap = entry ( key + value ) + entry ...
        Map<String, Integer> income = new HashMap<>();
        income.put("我", 200000);
        income.put("她", 100000);

        System.out.println(income.get("我"));
        System.out.println(income.get("她"));

        System.out.println("========================================");

        //method1
        for (Map.Entry<String, Integer> entry : income.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("========================================");

        //method2(lambda expression)
        income.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        System.out.println("=========================================");

        //method3(Iterator)
        //https://dotblogs.com.tw/kent2480/2014/01/10/139465
        Set set = income.entrySet();  //存成entrySet
        Iterator iterator = set.iterator();  //然後用iterator(set本身自帶iterator() method  //implement Iterable)

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //刪除元素
        income.remove("她");
        System.out.println(income); //直接印

    }
}
