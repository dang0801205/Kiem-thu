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

    /**
     * Test case cho week 5: Kiểm thử dòng điều khiển
     */
    @Test
    void test_doMucC1() {
        assertEquals("Passed with C1", grader.grade(60, 50, 40));
    }
    /**
     * Test case cho Path 1: Điểm không hợp lệ
     * Input: grade(99, 60, 50)
     * Expected: "Invalid score"
     */
    @Test
    void testPath1_InvalidScore() {
        String expected = "Invalid score";
        String actual = grader.grade(99, 60, 50);
        assertEquals(expected, actual);
    }

    /**
     * Test case cho Path 2: Rớt do điểm liệt
     * Input: grade(15, 60, 50)
     * Expected: "Failed"
     */
    @Test
    void testPath2_FailedByMinimumScore() {
        String expected = "Failed";
        String actual = grader.grade(15, 60, 50);
        assertEquals(expected, actual);
    }

    /**
     * Test case cho Path 3: Rớt do tổng điểm thấp
     * Input: grade(30, 30, 30)
     * Expected: "Failed"
     */
    @Test
    void testPath3_FailedByTotalScore() {
        String expected = "Failed";
        String actual = grader.grade(30, 30, 30);
        assertEquals(expected, actual);
    }

    /**
     * Test case cho Path 4: Đỗ C1
     * Input: grade(50, 50, 50) -> total = 150 >= 142
     * Expected: "Passed with C1"
     */
    @Test
    void testPath4_PassedWithC1() {
        String expected = "Passed with C1";
        String actual = grader.grade(50, 50, 50);
        assertEquals(expected, actual);
    }

    /**
     * Test case cho Path 5: Đỗ B2
     * Input: grade(40, 40, 40) -> 100 <= total = 120 < 142
     * Expected: "Passed with B2"
     */
    @Test
    void testPath5_PassedWithB2() {
        String expected = "Passed with B2";
        String actual = grader.grade(40, 40, 40);
        assertEquals(expected, actual);
    }


    /**
     * Test case cho week 7: Kiểm thử dòng đữ liệu
     * Test case 1: Đầu vào không hợp lệ (ngoài miền [0, 60])
     * Input: {70, 60, 70}
     * Expected: "Invalid score"
     */
    @Test
    void testCase1_InvalidScore() {
        String expected = "Invalid score";
        // Giả định thứ tự là (Vocabulary, ReadingGrammar, Listening)
        String actual = grader.grade(70, 60, 70);
        assertEquals(expected, actual);
    }

    /**
     * Test case 2: Trượt do điểm liệt (18 < 19)
     * Input: {18, 60, 60}
     * Expected: "Failed"
     */
    @Test
    void testCase2_FailedByMinScore() {
        String expected = "Failed";
        String actual = grader.grade(18, 60, 60);
        assertEquals(expected, actual);
    }

    /**
     * Test case 3: Trượt do tổng điểm (20+20+20 = 60 < 100)
     * Input: {20, 20, 20}
     * Expected: "Failed"
     */
    @Test
    void testCase3_FailedByTotalScore() {
        String expected = "Failed";
        String actual = grader.grade(20, 20, 20);
        assertEquals(expected, actual);
    }

    /**
     * Test case 4: Đậu mức C1 (50+50+50 = 150 >= 142)
     * Input: {50, 50, 50}
     * Expected: "Passed with C1"
     */
    @Test
    void testCase4_PassedWithC1() {
        String expected = "Passed with C1";
        String actual = grader.grade(50, 50, 50);
        assertEquals(expected, actual);
    }

    /**
     * Test case 5: Đậu mức B2 (35+35+35 = 105; 100 <= 105 < 142)
     * Input: {35, 35, 35}
     * Expected: "Passed with B2"
     */
    @Test
    void testCase5_PassedWithB2() {
        String expected = "Passed with B2";
        String actual = grader.grade(35, 35, 35);
        assertEquals(expected, actual);
    }

    /**
     * Test case 6: Trượt do điểm liệt (có 2 điểm liệt)
     * Input: {18, 18, 60}
     * Expected: "Failed"
     */
    @Test
    void testCase6_FailedByMultipleMinScores() {
        String expected = "Failed";
        String actual = grader.grade(18, 18, 60);
        assertEquals(expected, actual);
    }
    }