package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JLPTN1Test {

    private final JLPTN1 grader = new JLPTN1();

    @Test
    void test_case3_allNominal() {
        assertEquals("Failed", grader.grade(30, 30, 30));
    }

    @Test
    void test_case1_zAtMin() {
        assertEquals("Failed", grader.grade(30, 30, 0));
    }

    @Test
    void test_case2_zAtMinPlus() {
        assertEquals("Failed", grader.grade(30, 30, 1));
    }

    @Test
    void test_case4_zAtMaxMinus() {
        assertEquals("Passed with B2", grader.grade(30, 30, 59));
    }

    @Test
    void test_case5_zAtMax() {
        assertEquals("Passed with B2", grader.grade(30, 30, 60));
    }

    @Test
    void test_case6_yAtMin() {
        assertEquals("Failed", grader.grade(30, 0, 30));
    }

    @Test
    void test_case7_yAtMinPlus() {
        assertEquals("Failed", grader.grade(30, 1, 30));
    }

    @Test
    void test_case8_yAtMaxMinus() {
        assertEquals("Passed with B2", grader.grade(30, 59, 30));
    }

    @Test
    void test_case9_yAtMax() {
        assertEquals("Passed with B2", grader.grade(30, 60, 30));
    }

    // --- Các trường hợp thay đổi điểm Từ vựng & Chữ Hán ---
    @Test
    void test_case10_xAtMin() {
        assertEquals("Failed", grader.grade(0, 30, 30));
    }

    @Test
    void test_case11_xAtMinPlus() {
        assertEquals("Failed", grader.grade(1, 30, 30));
    }

    @Test
    void test_case12_xAtMaxMinus() {
        assertEquals("Passed with B2", grader.grade(59, 30, 30));
    }

    @Test
    void test_case13_xAtMax() {
        assertEquals("Passed with B2", grader.grade(60, 30, 30));
    }
    @Test
    void test_case14_xAtMax() {
        assertEquals("Passed with C1", grader.grade(60, 60, 30));
    }
    @Test
    void test_truotDoTongDiemThap() {
        assertEquals("Failed", grader.grade(40, 40, 19));
    }


    @Test
    void test_doMucB2() {
        assertEquals("Passed with B2", grader.grade(50, 50, 40));
    }


    @Test
    void test_doMucC1() {
        assertEquals("Passed with C1", grader.grade(60, 50, 40));
    }
}
