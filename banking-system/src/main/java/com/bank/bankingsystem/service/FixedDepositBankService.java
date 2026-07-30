package com.bank.bankingsystem.service;

import com.bank.bankingsystem.entity.FixedDepositAccount;
import com.bank.bankingsystem.exception.*;
import com.bank.bankingsystem.util.CalculateInterest;
import com.bank.bankingsystem.util.Print;
import com.bank.bankingsystem.util.Validation;
import org.springframework.stereotype.Service;

@Service
public class FixedDepositBankService {
    private FixedDepositAccount fixedDepositAccount;
    public FixedDepositBankService(FixedDepositAccount fixedDepositAccount) {
        this.fixedDepositAccount = fixedDepositAccount;
    }
    public void deposit (double depositAmount) {
        try {
            Validation.validateDepositAmount(depositAmount);
            fixedDepositAccount.setBalance(fixedDepositAccount.getBalance() + depositAmount);
            System.out.println("Deposited " + depositAmount+", current balance is " + fixedDepositAccount.getBalance());
        }catch(DepositAmountLessThanZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw (double withdrawAmount) {
        try {
            fixedDepositAccount.validateWithdraw(withdrawAmount);
            fixedDepositAccount.withdraw(withdrawAmount);

        }catch(BalanceLessThanMinimumBalanceException | NotMaturedEnoughToWithdrawException |
               OverDraftAmountIsInSufficientException | OverDraftAndBalanceAreInSufficientException | WithdrawAmountGreaterThanBalanceException e){
            System.out.println("Transaction failed : "+e.getMessage());
        }
    }

    public void calculateAnnualInterest() {
        CalculateInterest.calculateAnnualInterest(fixedDepositAccount);
    }

    public void printAccountSummary(){
        Print.printAccountSummary(fixedDepositAccount);
        calculateAnnualInterest();
        System.out.println("Account Balance After Annual Interest: " + fixedDepositAccount.getBalance());
    }

    public FixedDepositAccount getFixedDepositAccount() {
        return fixedDepositAccount;
    }
}
