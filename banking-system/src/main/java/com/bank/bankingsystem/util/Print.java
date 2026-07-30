package com.bank.bankingsystem.util;

import com.bank.bankingsystem.entity.BankAccount;

public class Print {
    public static void printAccountSummary(BankAccount account) {
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Balance: " + account.getBalance());
        System.out.println("Interest Rate: " + account.getInterestRate());
    }
}
