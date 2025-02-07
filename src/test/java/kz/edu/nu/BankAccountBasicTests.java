package kz.edu.nu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountBasicTests {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("12345", 100.0);
    }

    @Test
    void testValidAccountNumber() {
        assertEquals("12345", account.getAccountNumber(), "Account number should be correctly assigned.");
    }

    @Test
    void testInitialBalance() {
        assertEquals(100.0, account.getBalance(), "Initial balance should be correct");
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Deposit should increase balance");
    }

    @Test
    void testWithdraw() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance(), "Withdraw should decrease balance");
    }

    @Test
    void testWithdrawExactBalance() {
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void testDepositAfterWithdrawal() {
        account.withdraw(50.0);
        account.deposit(30.0);
        assertEquals(80.0, account.getBalance(), "Balance should be correct after withdrawal and deposit.");
    }

    @Test
    void testHasSufficientFundsTrue() {
        assertTrue(account.hasSufficientFunds(99), "Should return true for 99 when balance is 100.");
    }

    @Test
    void testHasSufficientFundsFalse() {
        assertFalse(account.hasSufficientFunds(101), "Should return false for 101 when balance is 50.");
    }

    @Test
    void testHasSufficientFundsExactMatch() {
        assertTrue(account.hasSufficientFunds(100), "Should return true for exact match.");
    }

    @Test
    void testHasSufficientFundsAfterSmallWithdrawal() {
        account.withdraw(40.0);
        assertTrue(account.hasSufficientFunds(30.0), "Should return true after partial withdrawal.");
    }

    @Test
    void testHasSufficientFundsAfterHugeWithdrawal() {
        account.withdraw(80.0);
        assertFalse(account.hasSufficientFunds(30.0), "Should return false after partial withdrawal.");
    }
}