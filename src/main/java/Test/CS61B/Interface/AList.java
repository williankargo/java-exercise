package Test.CS61B.Interface;

public class AList<peter> implements List61B<peter> {

    private peter[] items;
    private int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        items = (peter[]) new Object[100];   //注意這種寫法！！！
        size = 0;
    }

    @Override  //可以自己加上Override避免打錯
    public void insert(peter x, int position) {
        peter[] newItems = (peter[]) new Object[items.length + 1];

        System.arraycopy(items, 0, newItems, 0, position);
        newItems[position] = x;

        System.arraycopy(items, position, newItems, position + 1, items.length - position);
        items = newItems;
    }

    //分開寫比較好維護
    private void resize(int capacity) {
        peter[] a = (peter[]) new Object[capacity]; //create a new array
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    @Override
    public peter get(int i) {
        return items[i];
    }

    @Override
    public void addFirst(peter x) {
        insert(x, 0);
        size++;
    }

    @Override
    public peter getFirst() {
        return get(0);
    }

    @Override
    public void addLast(peter x) {
        if (size == items.length) {  //已經滿了
            resize(size + 1);  //可用 *RFACTOR 來降低搬移時間
        }
        items[size] = x;
        size++;
    }

    @Override
    public peter getLast() {
        return items[size - 1];
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public peter removeLast() {
        peter x = getLast();
        items[size - 1] = null;   //格子沒有變，但是要讓格子箭頭指向null不指向本來的東西，這樣本來的東西才會消失不浪費記憶體空間
        size--;
        return x;
    }
}