//package onedimensionalarray;
//
//import java.util.Scanner;
//
//public class test3 {
//
//  public static void main(String[] args) {
//    java.util.Scanner input = new Scanner(System.in);
//
//    System.out.println("Please enter the initial "
//        + "infectious patient number: ");
//    int people = input.nextInt();
//
//    System.out.println("Please enter the Basic Reproduction"
//        + " Number(R0): ");
//    int R = input.nextInt();
//
//    System.out.println("Please enter the statistical duration(Days):");
//    int days = input.nextInt();
//
//    calculate(people, R, days);
//  }
//
//  public static void calculate(int people, int R, int days) {
//    for (int i = 1; i < (days + 1); i++) {
//
//      int peopleInfect = people * R;
//      int j = 1;
//
//      do {
//        int peopleDied = (int) (peopleInfect * 0.1);
//      }while(j == 3);
//      j = j + 1;
//
//      System.out.println("Day " + i + "," + peopleInfect + " are indectious, " +
//          peopleDied + " people died from the virus.)";
//
//    }
//
//  }
//
//}
