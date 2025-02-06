package kz.edu.nu.arman.fintech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WalletTest {

    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet(100);
    }

    @Test
    void testDeposit() {
        wallet.deposit(50);

        Integer expected = 150;
        Integer actual = wallet.balance();

        assertEquals(expected, actual, "Balance should be 150 after depositing 50");
    }

    @Test
    void testWithdraw() {
        wallet.withdraw(30);

        Integer expected = 70;
        Integer actual = wallet.balance();

        assertEquals(expected, actual, "Balance should be 70 after withdrawing 30");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            wallet.withdraw(200);
        });
        assertEquals("Insufficient funds", exception.getMessage());
        assertEquals(100, wallet.balance(), "Balance should remain 100");
    }
}