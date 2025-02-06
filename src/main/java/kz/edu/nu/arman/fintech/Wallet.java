package kz.edu.nu.arman.fintech;

/**
 * @author Arman Sydikov
 */
public class Wallet {

    private Integer bitcoins;

    public Wallet(Integer bitcoins) {
        this.bitcoins = bitcoins;
    }

    public void deposit(Integer amount) {
        bitcoins += amount;
    }

    public Integer balance() {
        return bitcoins;
    }

    public void withdraw(Integer amount) {
        if (amount > bitcoins) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        bitcoins -= amount;
    }
}
