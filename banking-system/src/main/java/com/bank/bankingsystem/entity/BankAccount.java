package com.bank.bankingsystem.entity;

public abstract class BankAccount{
    private final String accountHolderName;
    private final String accountNumber;
    private double balance;
    public BankAccount(String accountHolderName, String accountNumber,double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract int getInterestRate();
    public abstract String getAccountType();
    public abstract void validateWithdraw(double withdrawAmount) throws RuntimeException;
    public abstract void withdraw(double withdrawAmount);


}
