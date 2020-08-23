package StreamDemo;

public class MyStudents {

    private String firstname;
    private String lastname;
    private String major;
    private int age;
    private double score;

    public MyStudents(String firstname, String lastname, String major, int age, double score) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.major = major;
        this.age = age;
        this.score = score;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
