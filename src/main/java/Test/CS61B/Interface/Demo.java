package Test.CS61B.Interface;

public class Demo {


    public static void main(String[] args) {
        List61B<String> someList = new SLList<>();

        someList.addFirst("elk");
        someList.addFirst("dwell");
        someList.addLast("on");
        someList.addLast("existential");
        someList.addLast("crises");

        someList.print();  //When Java runs a method that is overridden,
        // it searches for the appropriate method signature in it's dynamic type and runs it.
        //有override才能用dynamic的override方法，不然都是用static的方法

        System.out.println("++");
        peek(someList);
        // Overload: it checks the static type and calls the method with the parameter of the same type.


        System.out.println("======");

        List61B<String> array = new AList<>();
        array.addFirst("elk");
        array.addFirst("dwell");
        array.addLast("on");
        array.addLast("existential");
        array.addLast("crises");

        array.print();  //如果array沒有定義print(), 會使用到interface的方法


        System.out.println("++");
        peek(array);
        // Overload: it checks the static type and calls the method with the parameter of the same type.

    }


    //Overload
    public static void peek(List61B<String> list) {
        System.out.println(list.getLast());
    }

    //Overload
    public static void peek(SLList<String> list) {
        System.out.println(list.getFirst());
    }

}
