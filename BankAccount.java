package accounts;

import exceptions.InsufficientFundsException;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ", New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public synchronized void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + ", Remaining Balance: $" + balance);
        }
    }

    public synchronized void transfer(BankAccount targetAccount, double amount) throws InsufficientFundsException {
        if (targetAccount == null) {
            System.out.println("Invalid target account.");
            return;
        }
        this.withdraw(amount); // Withdraw from current account
        targetAccount.deposit(amount); // Deposit into target account
        System.out.println("Transferred $" + amount + " from " + this.accountNumber + " to " + targetAccount.getAccountNumber());
    }
}
