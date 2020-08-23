package objectAndClass;

public class IntegerDemo {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Integer.valueOf(10).compareTo(Integer.valueOf(11)));
        System.out.println(Integer.valueOf(10).compareTo(Integer.valueOf(10)));
        System.out.println(Integer.valueOf(10).compareTo(Integer.valueOf(9)));

        Integer o1 = Integer.valueOf("12");  //轉換成12
        System.out.println(o1 == 12); //boolean: ture

        System.out.println("=======================");
        System.out.println(Integer.parseInt("11"));

        System.out.println(Integer.parseInt("11", 2)); //說明此11為二進位，輸出轉為十進位
    }
}
