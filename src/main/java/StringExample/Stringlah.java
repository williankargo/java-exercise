package StringExample;

import java.lang.String;
import java.util.Arrays;

public class Stringlah {

    public static void main(String[] args) {
        String s = "Java"; //s指向java
        s = "HTML";      //s指向HTML
        System.out.println(s);

        String s1 = "Welcome to java";
        String s2 = new String("Welcome to java");
        String s3 = "Welcome to java";

        System.out.println("s1==s2 is " + (s1 == s2));//s1,s2指向不同實例（物件）
        System.out.println("s1==s3 is " + (s1 == s3));//s1,s3指向相同實例（物件）

        String a = "Welcome";
        System.out.println(a.replace('e', 'E'));
        System.out.println(a.replaceFirst("e", "E"));
        System.out.println(a.replaceAll("e", "E"));

        String b = "Java#is#great";
        String[] result = b.split("#");// 將line字串以逗號分割，並存在result字串陣列中
//  System.out.println(result);   //Array要轉換成String才可以print出
        System.out.println(Arrays.toString(result));

        //regular expression
        String k = "a+b$#c".replaceAll("[$+#]", "NNN");
        System.out.println(k);
        String[] tokens = "Java,C?C#,C++".split("[,?]");
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
        boolean boo = "Java is easy!".matches("Java.*");//是否是以Java開頭的string
        System.out.println(boo);

        //@string to char array
        String aa = "Welcome to Java";
        char[] charArray = aa.toCharArray();

        for (char e : charArray) {  //onedimensionalarray-arraysdemo2-method2
            System.out.println(e);
        }

        //char array to string 1
        String bb = new String(charArray);
        System.out.println(bb);
        System.out.println(bb instanceof String);//判斷是否為String類型

        //char array to string 2
        String cc = String.valueOf(charArray);
        System.out.println(cc);

        //int to string
        int integer = 1;
        String dd = integer + ""; //自通轉換
        System.out.println(dd);

        //format = 會返回值的printf()      d:整數  -:向左對齊
        String ss = String.format("%7.2f%6d%-4s", 45.556, 14, "AB");
        System.out.println(ss);
        System.out.printf("%6d", 14);  //沒有-就是向右對齊
    }
}
