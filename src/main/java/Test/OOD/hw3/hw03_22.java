package Test.OOD.hw3;


class hw_03 {

    public static void main(String[] args) {
        BBB b = new BBB(0);
        b.show(); //b.show() 會優先調用被override的method
    }
}

abstract class AAA {

    protected int num1 = 10;

    AAA(int x) {
        if (x < 3) {
            System.out.println("constructor: You cannot print this line");
        }
    }

    void func_1() {
        System.out.println("func_1: You cannot print this line");
    }

    abstract void func_2();

    private void func_3() {
        if (num1 > 0) {
            System.out.println("func_3: You cannot print this line");
        }
    }

    final void show() {
        func_1();
        func_2();
        func_3();
    }
}

class BBB extends AAA {

    BBB() {
        super(4);
        this.num1 = 0;
    }

    BBB(int x) {
        this();
    }

    @Override
    void func_2() {
    }

    @Override
    void func_1() {
    }

}


