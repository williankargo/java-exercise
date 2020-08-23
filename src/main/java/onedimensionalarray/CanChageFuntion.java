package onedimensionalarray;

public class CanChageFuntion {

    public static void main(String[] args) {

        printMax(34, 3, 3, 2, 44, 44.9);  //可知道語法糖的便利性，默認維數組
        printMax(new double[]{1, 2, 3}); //匿名數組

    }

    public static void printMax(double... numbers) { //數組的語法糖= duoble[] numbers
        if (numbers.length == 0) {
            System.out.println("No arguement passed.");
            return; //直接跳出去
        }

        double result = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}
