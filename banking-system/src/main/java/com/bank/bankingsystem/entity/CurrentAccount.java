package com.bank.bankingsystem.entity;

import com.bank.bankingsystem.exception.OverDraftAmountIsInSufficientException;
import com.bank.bankingsystem.exception.OverDraftAndBalanceAreInSufficientException;

public class CurrentAccount extends BankAccount {

    private double overdraft;

    public CurrentAccount(String accountHolderName, String accountNumber, double balance, double overdraft) {
        super(accountHolderName, accountNumber, balance);
        this.overdraft = overdraft;
    }

    @Override
    public int getInterestRate() {
        return 0;
    }

    @Override
    public String getAccountType() {
        return "Current";
    }

    @Override
    public void validateWithdraw(double withdrawAmount) throws RuntimeException {
        if (getBalance() == 0 && getOverdraft() < withdrawAmount) {
            throw new OverDraftAmountIsInSufficientException("Cannot withdraw, your balance is 0 and your overdraft is also insufficient");
        }

        double totalBalance = getBalance() + getOverdraft();
        if (withdrawAmount > totalBalance) {
            throw new OverDraftAndBalanceAreInSufficientException("Cannot withdraw, your balance and overdraft is also insufficient");
        }
    }
    @Override
    public void withdraw(double withdrawAmount) {
        if(withdrawAmount <= getBalance()) {
            setBalance(getBalance() - withdrawAmount);
            return;
        }
        double remainingBalance = withdrawAmount - getBalance();
        setBalance(0);
        setOverdraft(overdraft - remainingBalance);
    }

    public double getOverdraft() {
        return overdraft;
    }
    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

}
