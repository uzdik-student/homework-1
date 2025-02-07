package kz.edu.nu;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Student Grade Management System Tests")
@SelectClasses({StudentBasicTests.class, StudentAdvancedTests.class})
public class StudentTestSuite {
}
