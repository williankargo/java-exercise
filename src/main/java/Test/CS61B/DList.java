package Test.CS61B;

public class DList {

    public static void main(String[] args) {
        SLList<Integer> L2 = new SLList<>(5);
        L2.addFirst(2);
        L2.getFirst();
        L2.addLast(3);
        System.out.println(L2.size());
    }
}

class IntNode<peter> {

    public peter item;
    public IntNode next;

    public IntNode(peter i, IntNode n) {
        item = i;
        next = n;
    }
}

class SLList<peter> {


    //The "sentinel" reference always points to a sentinel node.
    //The front item (if it exists), is always at sentinel.next.item.
    //The size variable is always the total number of items that have been added.

    private IntNode sentinel;//!,一開始先創造一個空的東西
    private int size;

    public SLList() {
        sentinel = new IntNode(69, null);//69隨便放
        size = 0;
    }

    public SLList(peter x) {
        sentinel = new IntNode(69, null);//69隨便放
        sentinel.next = new IntNode(x, null);
        size += 1;
    }

    public void addFirst(peter x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);//由後往前看
    }

    public peter getFirst() {
        return (peter) sentinel.next.item;
    }

    public void addLast(peter x) {
        size += 1;
        IntNode p = sentinel.next; //可visualize理解為何要這項
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

//  private static int size(IntNode p) {
//    if (p.next == null) {
//      return 1;
//    }
//    return 1 + size(p.next);
//  }

    public int size() {
        return size;
    }
}



