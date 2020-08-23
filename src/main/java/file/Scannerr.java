package file;

import java.util.Scanner;

public class Scannerr {

    public static void main(String[] args) throws Exception {
        //create a file instance
        java.io.File file = new java.io.File("fileText2.txt");

        //create a scanner for the file
        Scanner input = new Scanner(file);

        //read data from a file
        while (input.hasNext()) { //如果input還有下一行
            String one = input.next();
            String two = input.next();
            String three = input.next();
            int four = input.nextInt();
            System.out.println(one + " " + two + " " + three + " " + four);
        }

        input.close();
    }
}
