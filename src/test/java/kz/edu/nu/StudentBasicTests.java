package kz.edu.nu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Fundamental tests such as adding grades, calculating GPA, and checking pass/fail conditions
 */
class StudentBasicTests {

    /**
     * Test class
     */
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("123", "Nurkhan");
    }

    @Test
    void testValidStudentId() {
        assertEquals("123", student.getStudentId(), "Student ID should be correctly assigned.");
    }

    @Test
    void testValidStudentName() {
        assertEquals("Nurkhan", student.getName(), "Student name should be correctly assigned.");
    }

    @Test
    void testAddSingleGrade() {
        // Execute test method
        student.addGrade(80.0);

        // Assertion statements
        assertEquals(1, student.getGrades().size(), "Should have 1 grade");
    }

    @Test
    void testAddMultipleGrades() {
        // Execute test methods
        student.addGrade(80.0);
        student.addGrade(90.0);

        // Assertion statements
        assertEquals(2, student.getGrades().size(), "Should have 2 grades");
    }

    @Test
    void testCorrectGradeStored() {
        // Execute test method
        student.addGrade(85.5);

        // Assertion statements
        assertEquals(85.5, student.getGrades().get(0), "Grade should be stored correctly");
    }

    @Test
    void testCalculateGPAWithOneGrade() {
        student.addGrade(95.0);

        // Execute test method
        double actual = student.calculateGPA();

        // Assertion statements
        assertEquals(95.0, actual, "GPA should be the single grade value");
    }

    @Test
    void testCalculateGPAWithMultipleGrades() {
        student.addGrade(80.0);
        student.addGrade(90.0);

        // Execute test method
        double actual = student.calculateGPA();

        // Assertion statements
        assertEquals(85.0, actual, "GPA should be average of grades");
    }

    @Test
    void testHasPassed() {
        student.addGrade(60.0);
        student.addGrade(70.0);

        // Execute test method
        boolean actual = student.hasPassed();

        // Assertion statements
        assertTrue(actual, "Student should pass with GPA >= 50.0");
    }

    @Test
    void testHasNotPassed() {
        student.addGrade(30.0);
        assertFalse(student.hasPassed(), "Student should fail with GPA < 50");
    }

    @Test
    void testStudentHasNoGradesInitially() {
        assertTrue(student.getGrades().isEmpty(), "New students should have no grades initially");
    }

    @Test
    void testAddingGradeDoesNotAffectPreviousGrades() {
        student.addGrade(85.0);
        student.addGrade(90.0);
        assertEquals(85.0, student.getGrades().get(0), "First grade should remain unchanged");
    }

}