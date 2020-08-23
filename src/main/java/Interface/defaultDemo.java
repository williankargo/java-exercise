package Interface;

interface Sayable {

    //可以在interface寫完方法，而且可以不用被@override
    default void say() {
        System.out.println("Hello");
    }

    //如果不想被強制@override且想寫完，也可以把方法寫成static
    static void sayLouder(String msg) {
        System.out.println(msg);
    }

    void sayMore(String msg);

}

public class defaultDemo implements Sayable {

    @Override
    public void sayMore(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Sayable demo = new defaultDemo();
        demo.say();
        demo.sayMore("china!");
        Sayable.sayLouder("taiwan!");
    }
}
