package com.bank.bankingsystem.service;

import com.bank.bankingsystem.entity.BankAccount;
import com.bank.bankingsystem.exception.*;
import com.bank.bankingsystem.util.CalculateInterest;
import com.bank.bankingsystem.util.Print;
import com.bank.bankingsystem.util.Validation;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private final BankAccount bankAccount;
    public BankService(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void deposit (double depositAmount) {
        try {
            Validation.validateDepositAmount(depositAmount);
            bankAccount.setBalance(bankAccount.getBalance() + depositAmount);
            System.out.println("Deposited " + depositAmount+", current balance is " + bankAccount.getBalance());
        }catch(DepositAmountLessThanZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw (double withdrawAmount) {
        try {
            bankAccount.validateWithdraw(withdrawAmount);
            bankAccount.withdraw(withdrawAmount);

        }catch(BalanceLessThanMinimumBalanceException | NotMaturedEnoughToWithdrawException |
               OverDraftAmountIsInSufficientException | OverDraftAndBalanceAreInSufficientException | WithdrawAmountGreaterThanBalanceException e){
            System.out.println("Transaction failed : "+e.getMessage());
        }
    }

    public void calculateAnnualInterest() {
        CalculateInterest.calculateAnnualInterest(bankAccount);
    }

    public void printAccountSummary(){
        Print.printAccountSummary(bankAccount);
        calculateAnnualInterest();
        System.out.println("Account Balance After Annual Interest: " + bankAccount.getBalance());
    }
}
