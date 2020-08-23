package Test.CS61B.Compare;


import java.util.Comparator;

public class Launcher {

    public static void main(String[] args) {
        Dog d1 = new Dog("E", 3);
        Dog d2 = new Dog("S", 9);
        Dog d3 = new Dog("B", 15);
        Dog[] dogs = new Dog[]{d1, d2, d3};

        Dog d = (Dog) Maximizer.max(dogs);
        d.bark();

        //Comparator
        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(d1, d2) > 0) {
            d1.bark();
        } else {
            d3.bark();
        }
    }
}

class Maximizer {

    public static Comparable max(Comparable[] items) {
        int maxDex = 0;
        for (int i = 0; i < items.length; i += 1) {
            int cmp = items[i].compareTo(items[maxDex]);
            if (cmp > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }
}

