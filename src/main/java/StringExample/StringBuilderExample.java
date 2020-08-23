package StringExample;

public class StringBuilderExample {

    public static void main(String[] args) {
        //｜也可以直接在這裡先給定數字製造capacity大小
        StringBuilder sb = new StringBuilder(); //單線程//還在暫存器中
        StringBuffer sb1 = new StringBuffer();  //多線程

        sb.append("Welcome");  //還在暫存器中
        sb.append(' ');
        sb.append("to");
        sb.append(' ');
        sb.append("Java");

        System.out.println(sb.toString());  //正式生成字符串對象

        //add
        sb.insert(11, "HTML and"); //從11開始插入
        System.out.println(sb.toString());

        //delete1
        sb.delete(8, 11);
        System.out.println(sb.toString());
        //delete2
        sb.deleteCharAt(8);
        System.out.println(sb.toString());

        //reverse
        sb.reverse();
        System.out.println(sb.toString());

        //capacity
        sb.capacity();
        System.out.println(sb.capacity());  //先給一定數量的房間
        System.out.println(sb.length());

        sb.append("1111111111111111111");   //超過房間數後
        System.out.println(sb.capacity());  //自動擴容，會有性能消耗
        System.out.println(sb.length());

        sb.trimToSize();     //不用多餘的房間, 避免浪費記憶體
        System.out.println(sb.capacity()); //capacity此時和length一樣大小


    }
}
