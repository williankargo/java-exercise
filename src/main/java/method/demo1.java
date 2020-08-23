package method;

public class demo1 {

    public static void main(String[] args) {  //void不會return value
        System.out.println("the grade is:");
        printGrade(78.5);

        System.out.println("the grade is:");
        printGrade(83);
    }

    public static void printGrade(double score) {
        if (score < 0 || score > 100) {
            return;  //如果在void加上return,會跳出去
        }
        if (score >= 90.0) {
            System.out.println("A");
        } else if (score >= 80.0) {
            System.out.println("B");
        } else if (score >= 70.0) {
            System.out.println("C");
        } else if (score >= 60.0) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
