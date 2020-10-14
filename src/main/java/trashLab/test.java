package trashLab;


import onedimensionalarray.Copy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class test {
    static ArrayList<String> arr = new ArrayList<>();

    static void test() {
        String var = "";
        Iterator<String> e = arr.iterator();
        while (e.hasNext()) {
            var = e.next();
            if (var.equals("A")) {
                arr.remove(var);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        arr.addAll(list1);

        test();
        for (String var : arr) {
            System.out.print(var + " ");
        }
    }
}


