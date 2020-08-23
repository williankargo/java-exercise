package dataStructure.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample1 {

    public static void main(String[] args) {

        Student stu1 = new Student();
        stu1.setScore(100);

        Student stu2 = new Student();
        stu2.setScore(90);

        Student stu3 = new Student();
        stu3.setScore(80);

        Map<Student, String> studentStringMap = new TreeMap(new Sorter2());

        studentStringMap.put(stu1, "good");
        studentStringMap.put(stu2, "bad");
        studentStringMap.put(stu3, "shit");

        studentStringMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

    }
}

class Sorter2 implements Comparator<Student> { //傳入Student類型

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getScore() - o1.getScore();
    }
}

class Student {

    private int id;
    private String name;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
