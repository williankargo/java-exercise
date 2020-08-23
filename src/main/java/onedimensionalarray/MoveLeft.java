package onedimensionalarray;

public class MoveLeft {

    public static void main(String[] args) {
        double[] myList = {1, 3, 5, 7, 9, 11};  //index到5，長度為6!!!!
        double temp = myList[0];
        for (int i = 1; i < myList.length; i++) {
            myList[i - 1] = myList[i];
        }
        myList[myList.length - 1] = temp;
        for (int i = 0; i < myList.length; i++) {
            System.out.print(myList[i] + " ");
        }
        System.out.println();
        for (double e : myList) {
            System.out.println(e);
        }
    }
}
