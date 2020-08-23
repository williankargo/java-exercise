package onedimensionalarray;

public class Max {

    public static void main(String[] args) {
        double myList[] = new double[10];
        for (int i = 0; i < myList.length; i++) {
            myList[i] = Math.random() * 100;
            System.out.print(myList[i] + " ");
        }
        double max = myList[0];
        int indexOfMax = 0;

        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
                indexOfMax = i;             //印出最大元素最小下標值
            }
        }
        System.out.println();
        System.out.println(max);
        System.out.println(indexOfMax);
    }
}
