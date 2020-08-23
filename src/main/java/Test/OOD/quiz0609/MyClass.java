package Test.OOD.quiz0609;

public class MyClass {

    public static void main(String[] args) {
        String tmp = "123456789ABCDEFGHIJKLMNOP";
        System.out.println(transform(tmp));
    }

    public static String transform(String t) {

        if (t == null || t.length() == 0) {
            return "";
        }

        String rem = transform(t.substring(1));  //擷取字串

        Character cc;

        if (Character.isDigit(t.charAt(0)) & t.charAt(0) % 2 != 0) {
            cc = t.charAt(0);
        } else {
            cc = 'i';
        }

        if (t.charAt(0) == 'P') {
            cc = Character.toUpperCase(t.charAt(0));
        } else if (!(Character.isDigit(t.charAt(0))) & t.charAt(0) % 2 == 0) {
            cc = Character.toLowerCase(t.charAt(0));
        } else if ((!(Character.isDigit(t.charAt(0))))) {
            cc = Character.toUpperCase(t.charAt(0));
        }

        String ans = rem + cc;
        ans = ans.replace("i", "");
        return ans;
    }
}

//
//奇大偶小
//public class MyClass {
//  public static void main(String args[]) {
//    String tmp = "123456789ABCDEFGHIJKLMNOP";
//    System.out.println(transform(tmp));
//  }
//
//  public static String transform(String t) {
//    // P不用處理直接return
//    if(t.length() == 1)
//      return t;
//
//    // 將第一個char的ascii number落在0~42間;
//    int char_num = t.charAt(0) - 48;
//
//    // 第一個字元是偶數數字
//    if((char_num >= 0) && (char_num <= 9) && (char_num % 2 == 0))   return transform(t.substring(1));
//      // 第一個字元是大寫字母且其ascii code是偶數(B、D、F...)
//    else if((char_num >= 17) && (char_num <= 42) && (char_num % 2 == 0)) return transform(t.substring(1)) + Character.toLowerCase(t.charAt(0));
//      // 第一個字元是大寫字母且其ascii code是奇數(A、C、E...)
//    else return transform(t.substring(1)) + t.charAt(0);
//
//  }
//}