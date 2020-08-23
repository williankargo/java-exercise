package Test.OOD.midterm;

public class quiz2 {

    public static void main(String[] args) {
        Y obj = new Y();
    }
}

class X {
    public X(int i) {
        System.out.println(1);
    }
}

class Y extends X {
    public Y() {
        super(3);  //random give a number
        System.out.println(2);
    }
}