package onedimensionalarray;

public class Copy {

    public static void main(String[] args) {
        int[] sourceArray = {1, 2, 3, 4, 5};
        int[] copyArray = new int[sourceArray.length];

        //method 1

//    for (int i = 0; i < sourceArray.length; i++) {
//      copyArray[i] = sourceArray[i];
//    }
//    for (int e : sourceArray) {
//      System.out.print(e);
//    }


        //method 2

        System.arraycopy(sourceArray, 0, copyArray, 0, sourceArray.length);
        for (int e : sourceArray) {
            System.out.print(e);
        }
    }
}
