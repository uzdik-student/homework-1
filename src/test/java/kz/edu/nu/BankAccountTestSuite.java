package kz.edu.nu;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Bank Account System Tests")
@SelectClasses({BankAccountBasicTests.class, BankAccountAdvancedTests.class})
public class BankAccountTestSuite {
}
