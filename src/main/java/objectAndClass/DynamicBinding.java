package objectAndClass;

public class DynamicBinding {

    public static void main(String[] args) {
        method2(new Peter());
        method2(new Father2());
        method2(new GrandFather2());
        method2(new Object());
        GrandFather2.testStatic();  //題外話，使用不同class中static method的方法

        //1
        //聲明類型決定在編譯時用哪個方法
        Object o = new Peter(); // =(Object)new Object() 隱式轉換，向上轉換可自動 //object：Object,GrandFather2,Father2,Peter
        System.out.println(o instanceof Object);
        Father2 b = (Father2) o; //顯式轉換，向下轉換需手動

        //2
        Object sample = new Children(); //object：Object,GrandFather,Father,Children
        if (sample instanceof Father2) { //sample是否為右邊class Father2的instance(object)
            System.out.println("Success!");
            Father2 sample2 = (Father2) sample; //會運行錯誤，把指向Object-Children實例鍊的sample和Object-Father2實例鍊不同
        }

        //3顯示轉換的意義
        Object sample3 = new GrandFather2();
        ((GrandFather2) sample3).testMethod(); //使用子類方法（在實例鍊中，可降維，雖然有實例但要降維才可以使用子輩方法 ）
        //對象是對象，實例是實例，有該類實例不代表可以用該類方法
    }

    public static void method2(Object object) { //方法不要放在main裡面!
        System.out.println(object.toString());
    }

}


class Peter extends Father2 {
//沒有toString方法，往上找
}

class Father2 extends GrandFather2 {

    public String toString() {
        return "Father2";
    }
}

class GrandFather2 extends Object {

    public String toString() {
        return "GrandFather2";
    }

    public static void testStatic() {
        System.out.println("testStatic!");
    }

    public void testMethod() {
        System.out.println("testMethod!");
    }


}

