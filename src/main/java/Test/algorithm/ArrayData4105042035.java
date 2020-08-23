package Test.algorithm;

public abstract class ArrayData4105042035 {

    public static void main(String[] args) {

        //create 10 double values randomly, A&B
        double[] A = new double[10];
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.random() * 100;
            System.out.print(A[i] + " ");
        }

        double[] B = new double[10];
        for (int i = 0; i < A.length; i++) {
            B[i] = Math.random() * 100;
            System.out.print(B[i] + " ");
        }

        System.out.println();//new line
        //1.maximum
        System.out.println("max: " + max(A));
        //2.average
        System.out.println("avg: " + avg(A));
        //3.reverse
        reverse(A);
        System.out.println();//new line
        //4.shuffle
        shuffle(A);
        System.out.println();//newline
        //5.toString
        System.out.println("contents: " + toString(A));
        //6.innerProduct
        System.out.println("inner product is " + inner_product(A, B));


    }

    //max
    public static double max(double... A) {
        double max = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    //average
    public static double avg(double... A) {
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            double temp = A[i];
            sum = sum + temp;
        }
        double avg = (sum / A.length);
        return avg;
    }

    //reverse
    public static void reverse(double... A) {
        for (int i = 0; i < A.length / 2; i++) {
            double temp = A[i];
            A[i] = A[A.length - i - 1];
            A[A.length - i - 1] = temp;
        }
        for (int i = 0; i < A.length; i++) { //print the array
            System.out.print(A[i] + " ");
        }
    }


    //shuffle
    public static void shuffle(double... A) {
        for (int i = 0; i < A.length; i++) {
            int j = (int) (Math.random() * A.length);
            double temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    //toString
    public static String toString(double... A) {
        String temp = "A";
        String words = "";
        for (int i = 0; i < A.length; i++) {
            temp = String.valueOf(A[i]);
            words = words + " " + temp;
        }
        return words;
    }

    //innerProduct
    public static double inner_product(double[] A, double[] B) {
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[i];
        }
        return sum;
    }

}

//  public int[] A;
//
//  public abstract int max();
//
//  public abstract int min();
