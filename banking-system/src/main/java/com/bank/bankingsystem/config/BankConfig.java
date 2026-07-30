package com.bank.bankingsystem.config;

import com.bank.bankingsystem.entity.BankAccount;
import com.bank.bankingsystem.entity.CurrentAccount;
import com.bank.bankingsystem.entity.FixedDepositAccount;
import com.bank.bankingsystem.entity.SavingsAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class BankConfig {
    @Bean
    public SavingsAccount savingsAccount() {
        return new SavingsAccount("John", "SAV-001", 1000);
    }
    @Bean
    public CurrentAccount currentAccount() {
        return new CurrentAccount("Marshad", "CUR-001", 500, 1000);
    }
    @Bean
    public FixedDepositAccount fixedDepositAccount() {
        return new FixedDepositAccount ("Jane","FD-001", 5000, LocalDate.now().minusDays(40));
    }
}
