package Test.CS61B.Compare;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {

    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog it) {
        return size - it.size;  // 如果是正的就是大於\ 負的就是小於\ =0就是等於
    }


    public void bark() {
        System.out.println(name + " says: bark");
    }


    //另外創造的比較器
    private static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}
