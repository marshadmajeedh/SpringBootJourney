package com.bank.bankingsystem.controller;

import com.bank.bankingsystem.dto.AmountRequest;
import com.bank.bankingsystem.entity.SavingsAccount;
import com.bank.bankingsystem.service.SavingBankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/savings")
public class SavingsController {
    private final SavingBankService savingBankService;

    public SavingsController(SavingBankService savingBankService) {
        this.savingBankService = savingBankService;
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String,Object>> getSummary() {
        SavingsAccount account = savingBankService.getSavingsAccount();

        HashMap<String,Object> map = new HashMap<>();
        map.put("Account type",account.getAccountType());
        map.put("Account holder name",account.getAccountHolderName());
        map.put("Account Number",account.getAccountNumber());
        map.put("Account balance",account.getBalance());
        map.put("Account interest rate",account.getInterestRate());

        return ResponseEntity.ok(map);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Map<String,Object>> deposit(@RequestBody AmountRequest amount) {
        savingBankService.deposit(amount.getAmount());
        SavingsAccount account = savingBankService.getSavingsAccount();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Deposit successful");
        response.put("deposited amount", amount.getAmount());
        response.put("new balance", account.getBalance());
        response.put("account number", account.getAccountNumber());
        return ResponseEntity.ok(response) ;
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Map<String,Object>> getWithdraw(@RequestBody AmountRequest amount) {
        savingBankService.withdraw(amount.getAmount());
        SavingsAccount account = savingBankService.getSavingsAccount();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "withdraw successful");
        response.put("withdrawn amount", amount.getAmount());
        response.put("new balance", account.getBalance());
        response.put("account number", account.getAccountNumber());

        return ResponseEntity.ok(response) ;
    }
}
