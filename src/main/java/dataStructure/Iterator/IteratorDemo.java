package dataStructure.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {

    public static void main(String[] args) {
        //ArrayList作為具體實現類
        Collection<String> collection = new ArrayList<>();

        collection.add("Taipei");
        collection.add("New York");
        collection.add("LA");

        System.out.println(collection);

        Iterator<String> iterator = collection.iterator();
        //使用Iterator :collection呼叫iterator()方法，回傳Iterator型態物件給Iterator it
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
