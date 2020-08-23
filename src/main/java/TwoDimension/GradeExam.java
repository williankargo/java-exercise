package TwoDimension;

public class GradeExam {

    public static void main(String[] args) {
        //Students's answers to the questions
        char[][] answers = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        //key to the questions
        char[] keys = {'B', 'G', 'I'};

        for (int i = 0; i < answers.length; i++) {
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == keys[j]) {
                    correctCount++;
                }
            }
            System.out.println("Student " + i + "'s correct count is: " + correctCount);
        }
    }
}
