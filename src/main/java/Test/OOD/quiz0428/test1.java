package Test.OOD.quiz0428;

public class test1 {

}

class Calculator {

    private int num1;
    private int num2;
    private int result;

    Calculator(int n1, int n2) {
        num1 = n1;
        num2 = n2;
    }

    void add() {
        Add a = new Add();
        a.add();
    }

    void subtract() {
        Subtract s = new Subtract();
    }

    void multiply() {
        Multiply m = new Multiply();
        m.multiply();
    }

    void divide() {
        Divide d = new Divide();
    }

    void show_result() {
        System.out.println(result);
    }

    class Add {
        void add() {
            result = num1 + num2;
        }
    }

    class Subtract {
        public Subtract() {
            result = num1 - num2;
        }
    }

    class Multiply {
        void multiply() {
            result = num1 * num2;
        }
    }

    class Divide {
        public Divide() {
            result = num1 / num2;
        }
    }
}
