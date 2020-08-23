package objectAndClass;

public class TestCircleWithStaticMembers {

    public static void main(String[] args) {
        System.out.println("Before creating objects");
        System.out.println("The number of Circle object is "
                + CircleWithStaticMembers2.numberOfObjects); //class.(static)value調用靜態變量

        CircleWithStaticMembers2 c1 = new CircleWithStaticMembers2();
        System.out.println("\nAfter creating c1");
        System.out.println("c1: radius (" + c1.radius
                + ") and number of Circle objects (" + c1.numberOfObjects + ")");
        c1.radius = 9;

        CircleWithStaticMembers2 c2 = new CircleWithStaticMembers2();
        System.out.println("\nAfter creating c2 and modifying c1");
        System.out.println("c1: radius (" + c1.radius
                + ") and number of Circle objects (" + c1.numberOfObjects + ")");
        System.out.println("c2: radius (" + c2.radius
                + ") and number of Circle objects (" + c2.numberOfObjects + ")");
        //static int numberOfObjects = 0;  因為是共用的，所以會變成2
        //其他非static 因為非共用，各自獨立

    }
}
