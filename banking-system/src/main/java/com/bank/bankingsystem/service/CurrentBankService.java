package com.bank.bankingsystem.service;

import com.bank.bankingsystem.entity.CurrentAccount;
import com.bank.bankingsystem.exception.*;
import com.bank.bankingsystem.util.CalculateInterest;
import com.bank.bankingsystem.util.Print;
import com.bank.bankingsystem.util.Validation;
import org.springframework.stereotype.Service;

@Service
public class CurrentBankService {
    private CurrentAccount  currentAccount;
    public CurrentBankService(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
    public void deposit (double depositAmount) {
        try {
            Validation.validateDepositAmount(depositAmount);
            currentAccount.setBalance(currentAccount.getBalance() + depositAmount);
            System.out.println("Deposited " + depositAmount+", current balance is " + currentAccount.getBalance());
        }catch(DepositAmountLessThanZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw (double withdrawAmount) {
        try {
            currentAccount.validateWithdraw(withdrawAmount);
            currentAccount.withdraw(withdrawAmount);

        }catch(BalanceLessThanMinimumBalanceException | NotMaturedEnoughToWithdrawException |
               OverDraftAmountIsInSufficientException | OverDraftAndBalanceAreInSufficientException | WithdrawAmountGreaterThanBalanceException e){
            System.out.println("Transaction failed : "+e.getMessage());
        }
    }

    public void calculateAnnualInterest() {
        CalculateInterest.calculateAnnualInterest(currentAccount);
    }

    public void printAccountSummary(){
        Print.printAccountSummary(currentAccount);
        calculateAnnualInterest();
        System.out.println("Account Balance After Annual Interest: " + currentAccount.getBalance());
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }
}
