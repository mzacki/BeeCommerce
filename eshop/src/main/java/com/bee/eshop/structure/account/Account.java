package com.bee.eshop.structure.account;

/**
 * Created by Matt on 28.12.2018 at 16:56.
 */

public class Account {

    private String accountNumber;
    private double balance;

    //TODO replace by BIG DECIMAL
    public void deposit(double depositAmount) {
        balance += depositAmount;
        System.out.printf("You've deposited " + depositAmount + " Your balance is " + balance);
    }

    public void withdraw(double withdrawalAmount) {
        if (balance - withdrawalAmount < 0) {
            System.out.println("Only " + balance + " available. Withdrawal not processed.");
        } else {
            balance -= withdrawalAmount;
            System.out.println("Processed. Remaining amount: " + balance);
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
