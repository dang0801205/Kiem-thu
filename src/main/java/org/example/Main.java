package org.example;

class JLPTN1 {
    public String grade(int VocabKanji, int listening, int ReadingGrammar) {
        if (VocabKanji < 0 || VocabKanji > 60 || listening < 0 || listening > 60 || ReadingGrammar < 0 || ReadingGrammar > 60) {
            return "Invalid score";
        }
        final int min_score = 19;
        if (VocabKanji < min_score || listening < min_score || ReadingGrammar < min_score) {
            return "Failed";
        }
        int total = VocabKanji + listening + ReadingGrammar;
        final int pass_score = 100;
        final int threshold = 142;
        if (total >= pass_score) {
            if (total >= threshold) {
                return "Passed with C1";
            } else {
                return "Passed with B2";
            }
        } else {
            return "Failed";
        }
    }
}


public class Main {
    public static void main(String[] args) {
        JLPTN1 grader = new JLPTN1();


        int[] scores1 = {40, 35, 25};
        String result1 = grader.grade(scores1[0], scores1[1], scores1[2]);
        System.out.println("Kết quả cho bộ điểm " + java.util.Arrays.toString(scores1) + ": " + result1);

        int[] scores2 = {55, 50, 45};
        String result2 = grader.grade(scores2[0], scores2[1], scores2[2]);
        System.out.println("Kết quả cho bộ điểm " + java.util.Arrays.toString(scores2) + ": " + result2);

        int[] scores3 = {60, 60, 18};
        String result3 = grader.grade(scores3[0], scores3[1], scores3[2]);
        System.out.println("Kết quả cho bộ điểm " + java.util.Arrays.toString(scores3) + ": " + result3);

        int[] scores4 = {-10, 50, 50};
        String result4 = grader.grade(scores4[0], scores4[1], scores4[2]);
        System.out.println("Kết quả cho bộ điểm " + java.util.Arrays.toString(scores4) + ": " + result4);
    }
}