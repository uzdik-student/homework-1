package kz.edu.nu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Parameterized tests, repeatable tests, and exception handling
 */
public class StudentAdvancedTests {

    /**
     * Test class
     */
    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("123", "Nurkhan");
    }

    @ParameterizedTest
    @ValueSource(doubles = {40.0, 50.0, 60.0})
    void testPassingThreshold(double grade) {
        student.addGrade(grade);

        // Execute test method
        boolean actual = student.hasPassed();
        boolean expected = (grade >= 50.0);

        // Assertion statements
        assertEquals(expected, actual);
    }

    @RepeatedTest(5)
    void testConsistentGPAComputation() {
        student.addGrade(70.0);
        student.addGrade(80.0);

        // Execute test method
        double actual = student.calculateGPA();

        // Assertion statements
        assertEquals(75.0, actual, "Repeated GPA calculation should be consistent");
    }

    @Test
    void testGradeBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(-10.0));
    }

    @Test
    void testGradeAbove100() {
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(105.0));
    }

    @Test
    void testEmptyGPA() {
        assertEquals(0.0, student.calculateGPA(), "GPA should be 0 for students with no grades");
    }

    @Test
    void testNullStudentId() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, "Nurkhan"));
    }

    @Test
    void testEmptyStudentId() {
        assertThrows(IllegalArgumentException.class, () -> new Student("", "Nurkhan"));
    }

    @Test
    void testNullStudentName() {
        assertThrows(IllegalArgumentException.class, () -> new Student("123", null));
    }

    @Test
    void testEmptyStudentName() {
        assertThrows(IllegalArgumentException.class, () -> new Student("123", ""));
    }
}
