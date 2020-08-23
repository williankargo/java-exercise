package Test.OOD.quiz0519;

public class test1 {

    public static void main(String[] args) {
        A[] a = new A[4];
        a[0] = new A();
        a[1] = new A2();
        a[2] = new B();
        a[3] = new C();

        for (int i = 0; i < a.length; i++) {
            a[i].show();
        }

    }
}

class A {
    protected int a = 5;

    public void show() {
        System.out.println("a= " + a);
    }
}

class A2 extends A {
    int a = 6;
}

class B extends A2 {
    protected int b2 = 7;

    public void show() {
        System.out.println("b = " + b2);
    }
}

class C extends B {
    protected int b = 8;

    public void show() {
        System.out.println("b = " + b2);
    }

}