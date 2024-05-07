package org.example.concurrency.task1;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
    private final Queue<T> queue;
    private final int maxSize;

    public BlockingQueue(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void enqueue(T item) throws Exception {
        while (queue.size() == maxSize) {
            wait();
        }
        if (queue.isEmpty()) {
            notifyAll();
        }
        queue.add(item);
    }

    public synchronized T dequeue() throws Exception {
        while (queue.isEmpty()) {
            wait();
        }
        if (queue.size() == maxSize) {
            notifyAll();
        }
        return queue.poll();
    }
}
