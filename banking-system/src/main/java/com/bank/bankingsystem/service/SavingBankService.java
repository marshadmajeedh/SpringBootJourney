package com.bank.bankingsystem.service;

import com.bank.bankingsystem.entity.SavingsAccount;
import com.bank.bankingsystem.exception.*;
import com.bank.bankingsystem.util.CalculateInterest;
import com.bank.bankingsystem.util.Print;
import com.bank.bankingsystem.util.Validation;
import org.springframework.stereotype.Service;

@Service
public class SavingBankService {
    private SavingsAccount savingsAccount;
    public SavingBankService(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public void deposit (double depositAmount) {
        try {
            Validation.validateDepositAmount(depositAmount);
            savingsAccount.setBalance(savingsAccount.getBalance() + depositAmount);
            System.out.println("Deposited " + depositAmount+", current balance is " + savingsAccount.getBalance());
        }catch(DepositAmountLessThanZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw (double withdrawAmount) {
        try {
            savingsAccount.validateWithdraw(withdrawAmount);
            savingsAccount.withdraw(withdrawAmount);

        }catch(BalanceLessThanMinimumBalanceException | NotMaturedEnoughToWithdrawException |
               OverDraftAmountIsInSufficientException | OverDraftAndBalanceAreInSufficientException | WithdrawAmountGreaterThanBalanceException e){
            System.out.println("Transaction failed : "+e.getMessage());
        }
    }

    public void calculateAnnualInterest() {
        CalculateInterest.calculateAnnualInterest(savingsAccount);
    }

    public void printAccountSummary(){
        Print.printAccountSummary(savingsAccount);
        calculateAnnualInterest();
        System.out.println("Account Balance After Annual Interest: " +savingsAccount.getBalance());
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }
}
