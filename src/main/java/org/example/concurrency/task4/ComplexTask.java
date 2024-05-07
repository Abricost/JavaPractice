package org.example.concurrency.task4;

import java.util.concurrent.ThreadLocalRandom;

public class ComplexTask {
    public void execute() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}