package Test.CS61B.Iterator;

import java.util.Iterator;

/* to do:
1. Make ArraySet implement the Iterable<T> interface.
2. Implement a toString method.
3. Implement an equals() method.
*/

public class ArraySet<T> implements Iterable<T> {

    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("cannot add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }


    public int size() {
        return size;
    }


    //Iterable的方法
    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }


    //改寫Iterator內的方法
    private class ArraySetIterator implements Iterator<T> {

        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() { //返回目前的值
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }


    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");   //StringBuilder可以自由伸縮
        for (int i = 0; i < size - 1; i += 1) {
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }


    @Override  //override from Object(不然原始的會是==(address))
    public boolean equals(
            Object other) {  // It must take an Object argument, in order to override the original .equals() method
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        //(1)
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }
        /** 原始的樣子, 所以必須用到Iterable & Iteration
         *  ArraySet<Integer> aset23 = new ArraySet<>();
         *  Iterator<Integer> seer = aset23.iterator();
         *  while (seer.hasNext()) {
         *    System.out.println(seer.next());
         *  }
         */

        //toString
        System.out.println(aset);

        /** 原始的樣子，所以要改寫toStirng不然會印出address
         *  String s = aset.toString();
         *  System.out.println(s);
         */


        //(2)
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        //equals
        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(null));
        System.out.println(aset.equals("fish"));
        System.out.println(aset.equals(aset));

    }
}
