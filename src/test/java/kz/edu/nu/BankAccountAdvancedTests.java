package kz.edu.nu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountAdvancedTests {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("12345", 100.0);
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.0, 50.0, 100.0})
    void testMultipleDeposits(double depositAmount) {
        account.deposit(depositAmount);
        assertEquals(depositAmount + 100, account.getBalance());
    }

    @RepeatedTest(5)
    void testConsistentDepositBehavior() {
        account.deposit(20.0);
        assertEquals(120.0, account.getBalance(), "Repeated deposit should be consistent");
    }

    @Test
    void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }

    @Test
    void testNegativeWithdrawal() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
    }

    @Test
    void testZeroDeposit() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
    }

    @Test
    void testZeroWithdrawal() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }

    @Test
    void testInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    @Test
    void testNullAccountNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(null, 100.0));
    }

    @Test
    void testEmptyAccountNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("", 100.0));
    }

}