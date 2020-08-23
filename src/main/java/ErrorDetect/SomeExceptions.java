package ErrorDetect;

public class SomeExceptions {

    public static void main(String[] args) {
        try {
            System.out.println("1");
            method1();
        } catch (Exception ex) {//Exception:所有例外
            System.out.println("5");
            ex.printStackTrace();
        }
    }

    //////////////////////////////////////
    public static void method1() throws Exception {
        try {
            System.out.println("2");
            method2();
        } catch (Exception ex) {
            System.out.println("4");
            throw new Exception("New info from method1", ex);
        }
    }

    public static int method2() throws Exception {  //把throws想成繼承的概念(聲明此方法會拋出以下異常）

        System.out.println("3");

        throw new Exception("New info from method2");
        //throw new ArithmeticException("New info from method2"); without throws Exception
    }

}
