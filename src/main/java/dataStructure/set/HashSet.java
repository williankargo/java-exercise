package dataStructure.set;

import java.util.Set;

public class HashSet { //set裡的元素是不能重複的

    public static void main(String[] args) {
        Set<String> hashset = new java.util.HashSet<>();   //interface Set中的實現 //如果要按照順序輸出，可以用LinkedHashSet()
        hashset.add("one");
        hashset.add("two");
        hashset.add("three");

        hashset.add("one");   //hashset不能重複

        System.out.println(hashset);

        hashset.remove("one");
        System.out.println(hashset);

        System.out.println(hashset.contains("two"));


        //HashSet可進行交集
        Set<String> hashset2 = new java.util.HashSet<>();
        hashset2.add("three");
        hashset2.add("four");
        hashset2.add("five");

        hashset.removeAll(hashset2);
        System.out.println(hashset);

        hashset.retainAll(hashset2); //取交集
        System.out.println(hashset);


    }
}
