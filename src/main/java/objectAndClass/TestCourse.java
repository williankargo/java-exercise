package objectAndClass;

public class TestCourse {

    public static void main(String[] args) {

        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Database systems");

        course1.addStudents("Peter");
        course1.addStudents("Maggie");
        course1.addStudents("Derek");

        course2.addStudents("Peter");
        course2.addStudents("Derek");

        System.out.println("Number of students in course1:" + course1.getNumberOfStudents());

        String[] studentsInCourse1 = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++) {
            System.out.println(studentsInCourse1[i] + ",");
        }


    }
}
