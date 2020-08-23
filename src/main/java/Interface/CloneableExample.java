package Interface;

import java.util.Arrays;
import java.util.Date;


public class CloneableExample {

    public static void main(String[] args) {
        Date ins1 = new Date();
        Date ins2 = (Date) ins1.clone();//因為是object類型，所以要向下轉換

        System.out.println(ins1 == ins2); //兩個不同的實例

        int[] list1 = {1, 2};
        int[] list2 = list1.clone();
        list1[0] = 7;
        list2[0] = 8;
        System.out.println(Arrays.toString(list1));
        System.out.println(Arrays.toString(list2));
    }
}
