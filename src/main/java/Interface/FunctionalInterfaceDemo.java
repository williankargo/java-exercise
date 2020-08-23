package Interface;

interface talk {
}

@FunctionalInterface
interface Say extends talk {  // interface可以繼承interface

    //只能有一個抽象方法
    void say(String msg);

    //可以有多個Object class method
    int hashCode();

    String toString();

    boolean equals(Object obj);

    //可以有static
    static void sayHi() {
        System.out.println("Heyyy");
    }

    //可以有default
    default void say() {
        System.out.println("Hello");
    }
}


public class FunctionalInterfaceDemo {  //implements Say


//    @Override
//    public void say(String msg) {
//        System.out.println(msg);
//    }

    public static void main(String[] args) {
//        FunctionalInterfaceDemo demo = new FunctionalInterfaceDemo();
//        demo.say("Fuck you!");

        //lambda expression
        Say demo2 = (msg) -> {
            System.out.println(msg);
        };
        demo2.say("Fuck you !");

    }

}
