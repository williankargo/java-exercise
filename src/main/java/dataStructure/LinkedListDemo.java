package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<Integer>(); //雙向連接，查找困難、插入容易
        integerList.add(5);
        integerList.add(6);
        integerList.add(2, 7);
        System.out.println(integerList);

        integerList.remove(0);
        System.out.println(integerList);

    }
}
