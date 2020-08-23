package Test.OOD.midterm2;

public class quiz2_2 {

    public static void main(String[] args) {
        Y obj = new Y();
    }
}

class X {

    public X(int i) {
        System.out.println(1);
    }

    public X() {
    }  //新增無參constructor
}

class Y extends X {

    public Y() {
        System.out.println(2);
    }
}
