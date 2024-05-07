package org.example.concurrency.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    final Lock lock = new ReentrantLock();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public boolean deposit(int amount) {
        if (amount < 0) {
            return false;
        }
        lock.lock();
        try {
            balance += amount;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}