package com.bank.bankingsystem;

import com.bank.bankingsystem.service.CurrentBankService;
import com.bank.bankingsystem.service.FixedDepositBankService;
import com.bank.bankingsystem.service.SavingBankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BankTestRunner implements CommandLineRunner {

    private SavingBankService savingBankService;
    private FixedDepositBankService  fixedDepositBankService;
    private CurrentBankService currentBankService;

    public BankTestRunner(SavingBankService savingBankService, FixedDepositBankService fixedDepositBankService, CurrentBankService currentBankService) {
        this.savingBankService = savingBankService;
        this.fixedDepositBankService = fixedDepositBankService;
        this.currentBankService = currentBankService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println ("==========Testing Savings Account==========");
        savingBankService.printAccountSummary();
        savingBankService.deposit(5000);
        savingBankService.withdraw(1000);
        savingBankService.printAccountSummary();
        savingBankService.calculateAnnualInterest();
        System.out.println ("\n==========Testing Current Account==========");
        currentBankService.printAccountSummary();
        currentBankService.deposit(5000);
        currentBankService.withdraw(1000);
        currentBankService.printAccountSummary();
        currentBankService.calculateAnnualInterest();
        System.out.println ("\n==========Testing Fixed Deposit Account==========");
        fixedDepositBankService.printAccountSummary();
        fixedDepositBankService.deposit(5000);
        fixedDepositBankService.withdraw(1000);
        fixedDepositBankService.printAccountSummary();
        fixedDepositBankService.calculateAnnualInterest();
    }
}
