package method;

public class demo2 {

    public static void main(String[] args) {
        System.out.println("The grade is " + getGrade(78.5));
        System.out.println("\nThe grade is " + getGrade(85));
    }

    public static char getGrade(double score) {   //返回值為char
        if (score >= 90.0) {
            return 'A';                               //"String" & 'char'
        } else if (score >= 80.0) {
            return 'B';
        } else if (score > 70.0) {
            return 'C';
        } else if (score >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
