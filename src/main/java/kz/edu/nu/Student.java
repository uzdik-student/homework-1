package kz.edu.nu;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String studentId;
    private final String name;
    private final List<Double> grades;

    public Student(String studentId, String name) {
        if (studentId == null || studentId.isEmpty()) {
            throw new IllegalArgumentException("Student ID should not be empty");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Student ID should not be empty");
        }
        this.studentId = studentId;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        grades.add(grade);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public boolean hasPassed() {
        return calculateGPA() >= 50.0;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
}
