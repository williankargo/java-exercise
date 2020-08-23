package Test.CS61B.Interface;

public class SLList<peter> implements List61B<peter> {


    private class Node {

        public peter item;
        public Node next;

        public Node(peter i, Node n) {
            item = i;
            next = n;
        }
    }


    private Node sentinel;
    private int size;


    //constructor1
    //empty SLList.
    public SLList() {
        sentinel = new Node(null,
                null);  //the first item(if it exists) is at sentinel.next. and its value is null
        size = 0;
    }

    //constructor2
    public SLList(peter x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    @Override
    public void insert(peter x, int position) {
        Node p = sentinel;
        while (position > 1 && p.next != null) {
            position--;
            p = p.next;
        }
        Node newNode = new Node(x, p.next);  //連後面
        p.next = newNode;
        size += 1;
    }

    @Override
    public void addFirst(peter x) {
        sentinel.next = new Node(x, sentinel.next);
        size += 1;
    }

    @Override
    public void addLast(peter x) {
        size = size + 1;
        Node p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
    }

    @Override
    public peter getFirst() {
        return sentinel.next.item;
    }


    //return the back node of the list.
    private Node getLastNode() {
        Node p = sentinel;

        //move p until it reaches the end.
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    @Override
    public peter getLast() {
        Node back = getLastNode();
        return back.item;
    }

    private peter get(int i, Node p) {
        if (i == 0) {
            return p.item;
        }
        return get(i - 1, p.next);
    }

    @Override
    public peter get(int i) {
        return get(i, sentinel);  //I fix it but I'm not really sure.
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public peter removeLast() {
        Node back = getLastNode();

        if (back == sentinel) {
            return null;
        }
        Node p = sentinel;

        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        return back.item;
    }

    @Override
    public void print() {
        System.out.println("this is the overridden version.");
        Node p = sentinel.next;
        while (p != null) {
            System.out.println(p.item + " ");
            p = p.next;
        }

    }


}
