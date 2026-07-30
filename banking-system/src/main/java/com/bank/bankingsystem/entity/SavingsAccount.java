package com.bank.bankingsystem.entity;

import com.bank.bankingsystem.exception.BalanceLessThanMinimumBalanceException;
import com.bank.bankingsystem.exception.WithdrawAmountGreaterThanBalanceException;

public class SavingsAccount extends BankAccount{

    //amount of balance that a savings account must have
    private double minimumBalance = 500;
    public SavingsAccount(String accountHolderName, String accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int getInterestRate() {
        return 4;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }

    @Override
    public void validateWithdraw(double withdrawAmount) throws RuntimeException {
        if (withdrawAmount > getBalance()) {
            throw new WithdrawAmountGreaterThanBalanceException("Cannot withdraw, insufficient balance");
        }

        double potentialBalanceAfterWithdraw = getBalance() - withdrawAmount;
        if (potentialBalanceAfterWithdraw < getMinimumBalance()){
            throw  new BalanceLessThanMinimumBalanceException("Cannot withdraw, balance is less than minimum balance "+getMinimumBalance());
        }
    }

    @Override
    public void withdraw(double withdrawAmount) {
        setBalance(getBalance() - withdrawAmount);
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }
    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}

