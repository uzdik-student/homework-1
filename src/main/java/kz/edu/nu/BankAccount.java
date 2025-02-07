package kz.edu.nu;

public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        if (accountNumber == null || accountNumber.isEmpty()) throw new IllegalArgumentException("Account number should not be empty");
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative.");
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public boolean hasSufficientFunds(double amount) {
        return balance >= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
