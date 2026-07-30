package com.bank.bankingsystem.entity;

import com.bank.bankingsystem.exception.NotMaturedEnoughToWithdrawException;
import com.bank.bankingsystem.exception.WithdrawAmountGreaterThanBalanceException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FixedDepositAccount extends BankAccount{
    private final LocalDate bod;
    public FixedDepositAccount(String accountHolderName, String accountNumber, double balance,LocalDate bod) {
        super(accountHolderName, accountNumber, balance);
        this.bod = bod;
    }

    @Override
    public int getInterestRate() {
        return 7;
    }

    @Override
    public String getAccountType() {
        return "FixedDeposit";
    }

    @Override
    public void validateWithdraw(double withdrawAmount) throws RuntimeException {
        if (withdrawAmount > getBalance()) {
            throw new WithdrawAmountGreaterThanBalanceException("Cannot withdraw, insufficient balance");
        }
        LocalDate today = LocalDate.now();
        boolean isMatured = ChronoUnit.DAYS.between(getBod(),today) >= 30;
        if (!isMatured) {
            throw new NotMaturedEnoughToWithdrawException("Not matured enough to withdraw");
        }
    }

    @Override
    public void withdraw(double withdrawAmount) {
        setBalance(getBalance() - withdrawAmount);
    }

    public LocalDate getBod() {
        return bod;
    }

}

