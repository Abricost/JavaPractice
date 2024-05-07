package org.example.concurrency.task2;

import java.util.ArrayList;
import java.util.List;

class ConcurrentBank {
    private final List<BankAccount> accounts;

    public ConcurrentBank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(int initialBalance) {
        BankAccount account = new BankAccount(initialBalance);
        accounts.add(account);
        return account;
    }

    public boolean transfer(BankAccount fromAccount, BankAccount toAccount, int amount) {
        if (fromAccount.withdraw(amount)) {
            if (toAccount.deposit(amount)) {
                return true;
            } else {
                fromAccount.deposit(amount);
            }
        }
        return false;
    }

    public int getTotalBalance() {
        int totalBalance = 0;
        for (BankAccount account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
}
