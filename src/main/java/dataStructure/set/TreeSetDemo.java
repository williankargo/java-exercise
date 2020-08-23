package dataStructure.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        Set<String> set = new TreeSet();

        set.add("CCC");
        set.add("BB");
        set.add("A");

        System.out.println(set);    //按照字母順序排序
    }

}
