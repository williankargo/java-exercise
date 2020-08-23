package Test.OOD.quizStart;

import java.util.Scanner;

class Data {

    String name;
    int mathScore;
    int EnglishScore;
    int ChineseScore;
    float averageScore;

    void setName(String name) {
        this.name = name;
    }

    void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    void setEnglishScore(int EnglishScore) {
        this.EnglishScore = EnglishScore;
    }

    void setChineseScore(int ChineseScore) {
        this.ChineseScore = ChineseScore;
    }

    float averageScore() {
        averageScore = (mathScore + EnglishScore + ChineseScore) / 3;
        return averageScore;
    }

    void printScore() {
        System.out.println(name + " " + averageScore);
    }
}

public class quiz2 {

    //讓10個人能輸入成績並列印
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Data[] student = new Data[2];   //object array, not purely array, student point to null!這裡創造兩個空間
        for (int i = 0; i < 2; i++) {
            student[i] = new Data();     //student[i]使用constructor
            System.out.println("name: ");
            String name = input.next();
            student[i].setName(name);
            System.out.println("math score: ");
            int score1 = input.nextInt();
            student[i].setMathScore(score1);
            System.out.println("english score: ");
            int score2 = input.nextInt();
            student[i].setEnglishScore(score2);
            System.out.println("chinese score: ");
            int score3 = input.nextInt();
            student[i].setChineseScore(score3);

            student[i].averageScore();

            student[i].printScore();

        }
    }
}
