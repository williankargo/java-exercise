package objectAndClass;

public class LocalVariable {

    private int x = 0;
    private int y = 0;

    public LocalVariable() {

    }

    public void p() {
        int x = 1;  //local variable比較優先被執行
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

}
