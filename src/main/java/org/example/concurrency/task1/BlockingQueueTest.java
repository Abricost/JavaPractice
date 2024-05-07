package org.example.concurrency.task1;

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        Thread producer1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.enqueue(i);
                    System.out.println("Producer 1: Enqueued " + i);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread producer2 = new Thread(() -> {
            try {
                for (int i = 10; i < 20; i++) {
                    queue.enqueue(i);
                    System.out.println("Producer 2: Enqueued " + i);
                    Thread.sleep(700);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                while (true) {
                    int item = queue.dequeue();
                    System.out.println("Consumer 1: Dequeued " + item);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while (true) {
                    int item = queue.dequeue();
                    System.out.println("Consumer 2: Dequeued " + item);
                    Thread.sleep(800);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
