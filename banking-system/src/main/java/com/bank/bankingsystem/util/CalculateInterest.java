package com.bank.bankingsystem.util;


import com.bank.bankingsystem.entity.BankAccount;

public class CalculateInterest {
    public static void calculateAnnualInterest(BankAccount account) {
        double interest = account.getInterestRate() / 100.0;
        double dailyInterestRate = interest/365.0;

        double annualEarnings = 0;
        for(int i = 1; i <= 365; i++) {
            annualEarnings += dailyInterestRate * account.getBalance();
        }

        account.setBalance(annualEarnings+account.getBalance());
    }
}
