package com.bank.bankingsystem.controller;

import com.bank.bankingsystem.dto.AmountRequest;
import com.bank.bankingsystem.entity.CurrentAccount;
import com.bank.bankingsystem.service.CurrentBankService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/current")
public class CurrentController {
    private final CurrentBankService currentBankService;
    public CurrentController(CurrentBankService currentBankService) {
        this.currentBankService = currentBankService;
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String,Object>> summary(){
        CurrentAccount account = currentBankService.getCurrentAccount();

        HashMap<String,Object> map = new HashMap<>();
        map.put("Account type",account.getAccountType());
        map.put("Account holder name",account.getAccountHolderName());
        map.put("Account Number",account.getAccountNumber());
        map.put("Account balance",account.getBalance());
        map.put("Account interest rate",account.getInterestRate());

        return ResponseEntity.ok(map);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Map<String,Object>> deposit(@RequestParam AmountRequest amount) {
        currentBankService.deposit(amount.getAmount());
        CurrentAccount account = currentBankService.getCurrentAccount();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Deposit successful");
        response.put("depositedAmount", amount.getAmount());
        response.put("newBalance", account.getBalance());
        response.put("accountNumber", account.getAccountNumber());

        return  ResponseEntity.ok(response);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Map<String,Object>> withdraw(@RequestParam AmountRequest amount) {
        currentBankService.withdraw(amount.getAmount());
        CurrentAccount account = currentBankService.getCurrentAccount();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "withdraw successful");
        response.put("withdrawn amount", amount.getAmount());
        response.put("new balance", account.getBalance());
        response.put("account number", account.getAccountNumber());

        return  ResponseEntity.ok(response);
    }
}
