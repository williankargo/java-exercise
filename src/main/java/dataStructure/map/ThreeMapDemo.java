package dataStructure.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ThreeMapDemo {

    public static void main(String[] args) {
        Map<Integer, String> treeMap = new TreeMap(new Sorter()); //TreeMap使用比較器Sorter, 本身其實也可以排序
        treeMap.put(3, "Peter");
        treeMap.put(2, "Derek");
        treeMap.put(1, "Maggie");

        treeMap.forEach((I, S) -> {
            System.out.println(I + ":" + S);
        });
    }
}

class Sorter implements Comparator<Integer> { //可自行設定改變排序順序

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}






