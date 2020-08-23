package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class PerformanceTest {

    static final int N = 50000;

    public static void main(String[] args) {

        //先創造一個sample
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        //打亂
        Collections.shuffle(list);

        System.out.println("======================HashSet==========================");
        Collection<Integer> hashset = new HashSet<>(list);  //以下的母體皆是Collection
        System.out.println("find time for hashset is " + getFindTime(hashset) + " milliseconds.");
        System.out.println("remove time for hashset is " + getRemoveTime(hashset) + " milliseconds.");

        System.out.println("======================TreeSet==========================");
        Collection<Integer> treeset = new TreeSet<>(list);
        System.out.println("find time for treeset is " + getFindTime(treeset) + " milliseconds.");
        System.out.println("remove time for treeset is " + getRemoveTime(treeset) + " milliseconds.");

        System.out.println("======================ArrayList==========================");
        Collection<Integer> arraylist = new ArrayList<>(list);
        System.out.println("find time for arraylist is " + getFindTime(arraylist) + " milliseconds.");
        System.out.println("remove time for arraylist is " + getRemoveTime(arraylist) + " milliseconds.");

        System.out.println("======================LinkedList==========================");
        Collection<Integer> linkedlist = new LinkedList<>(list);
        System.out.println("find time for linkedlist is " + getFindTime(linkedlist) + " milliseconds.");
        System.out.println("remove time for linkedlist is " + getRemoveTime(linkedlist) + " milliseconds.");


    }

    //查找
    public static long getFindTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            c.contains((int) (Math.random() * 2 * N));
        }
        return System.currentTimeMillis() - startTime;
    }

    //刪除
    public static long getRemoveTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            c.remove(i);
        }
        return System.currentTimeMillis() - startTime;
    }
}




