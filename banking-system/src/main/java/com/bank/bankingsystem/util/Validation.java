package com.bank.bankingsystem.util;

import com.bank.bankingsystem.exception.DepositAmountLessThanZeroException;

public class Validation {

    public static void validateDepositAmount(double depositAmount) {
        if (depositAmount < 0) {
            throw new DepositAmountLessThanZeroException("Deposit amount is negative");
        }
    }
}
