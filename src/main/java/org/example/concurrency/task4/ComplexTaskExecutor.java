package org.example.concurrency.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final int numberOfTasks;
    private final ExecutorService executorService;
    private final CyclicBarrier cyclicBarrier;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
        this.executorService = Executors.newFixedThreadPool(numberOfTasks);
        this.cyclicBarrier = new CyclicBarrier(numberOfTasks, this::mergeResults);
    }

    public void executeTasks(int numberOfTasks) {
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfTasks; i++) {
            futures.add(executorService.submit(() -> {
                ComplexTask complexTask = new ComplexTask();
                complexTask.execute();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }));
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private void mergeResults() {
        System.out.println("All tasks have completed. Merging results...");
    }
}