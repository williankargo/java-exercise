package input;

import java.util.Scanner;

public class input {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  //load in library

        byte byteValue = input.nextByte();  //read an number as byte type.
        System.out.println(byteValue);
//只需要輸入一次input
        int intValue = input.nextInt(); //read an number as integer type.
        System.out.println(intValue);
    }
}
