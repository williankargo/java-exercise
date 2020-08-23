package Test.OOD.quiz0616;

import java.util.LinkedList;
import java.util.TreeSet;

public class Myclass {

    public static void main(String[] args) {
        TreeSet<Integer> tset = new TreeSet<Integer>();
        LinkedList<Integer> llist = new LinkedList<Integer>();


        for (int i = 3; i > 0; i--) {
            tset.add(i);
            llist.add(i);
        }

        tset.add(4);
        llist.add(4);

        System.out.println("TreeSet: " + tset);  //TreeSet會自動排序
        System.out.println("LinkedList: " + llist);
    }
}
