package kz.edu.nu.fintech;

/**
 * @author Arman Sydikov
 */
public class Wallet {

    private Integer bitcoin;

    public Wallet(Integer bitcoin) {
        this.bitcoin = bitcoin;
    }

    public void deposit(Integer amount) {
        bitcoin += amount;
    }

    public Integer balance() {
        return bitcoin;
    }

    public void withdraw(Integer amount) {
        if (amount > bitcoin) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        bitcoin -= amount;
    }
}
