package onedimensionalarray;

public class demo1 {

    public static void main(String[] args) {
        double[] myList = new double[5];  //new創建數組
        myList[0] = 0;
        myList[1] = 1;
        myList[2] = 2;
        myList[3] = 3;
        myList[4] = 4;

        System.out.println(myList[4]);

        double[] myfault = {1.0, 2.0, 3.0, 8.7};  //也可以直接幫數組加上值

//    double[] myfault;                    這樣不行
//    myfault = {1.0,2.0,3.0,8.7};

        System.out.println(myfault.length);
        System.out.println(myfault[2]);

    }
}
