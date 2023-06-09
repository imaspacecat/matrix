package org.dubiner;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadQueue {
    private final LinkedBlockingQueue<MultOp> input;
    private final LinkedBlockingQueue<Double> result;
    private final Thread[] threads;
    private boolean done = false;


    public ThreadQueue(int threadCount, LinkedBlockingQueue<MultOp> input) {
        this.input = input;
        result = new LinkedBlockingQueue<>();
        threads = new Thread[threadCount];
        create();
    }

    // defaults to 4 threads
    public ThreadQueue(LinkedBlockingQueue<MultOp> input) {
        this(4, input);
    }

    public void create() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                while (!done) {
                    MultOp multOp = input.poll();
                    if (multOp != null) {
//                        System.out.println("here");
                        result.add(multOp.calculate());
                    }
                }
            }, "Thread " + i);
        }
    }

    public void start() {
        for (Thread t : threads) {
//            System.out.println(t);
            t.start();
        }
    }

    public boolean isDone() {
        return done;
    }

    public void stop() {
        done = true;
    }

    public LinkedBlockingQueue<Double> getResult() {
        return result;
    }
}
