package Test.CS61B.Interface;

public interface List61B<peter> {

    public void insert(peter x, int position);

    public void addFirst(peter x);

    public void addLast(peter x);

    public peter getFirst();

    public peter getLast();

    public peter get(int i);

    public int size();

    public peter removeLast();

    //interface允許用default寫出詳細方法
    default public void print() {
        for (int i = 0; i < size(); i += 1) {
            System.out.println(get(i) + " ");
        }
        System.out.println("print from Interface.");
    }
}
