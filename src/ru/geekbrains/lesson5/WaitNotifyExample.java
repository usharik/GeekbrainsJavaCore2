package ru.geekbrains.lesson5;

import java.util.Deque;
import java.util.LinkedList;

public class WaitNotifyExample {

    Deque<String> deque = new LinkedList<>();

    public synchronized String get() throws InterruptedException {
        if (deque.isEmpty()) {
            this.wait();
        }
        return deque.pollLast();
    }

    public synchronized void add(String str) {
        deque.add(str);
        this.notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();

        Thread thr = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    sleep(1000);
                    waitNotifyExample.add(String.valueOf(System.currentTimeMillis()));
                }
            }
        });
        thr.start();

        Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (true) {
                        try {
                            System.out.printf("Thread 1 value %s%n", waitNotifyExample.get());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thr1.start();

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (true) {
                        try {
                            System.out.printf("Thread 2 value %s%n", waitNotifyExample.get());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thr2.start();

        Thread thr3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (true) {
                        try {
                            System.out.printf("Thread 3 value %s%n", waitNotifyExample.get());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thr3.start();

    }

    private final Object monitor = new Object();

    private void example() throws InterruptedException {
        System.out.println("Some code");

        synchronized (monitor) {
            monitor.wait();
        }
    }

    private static void example1() throws InterruptedException {
        synchronized (WaitNotifyExample.class) {
            WaitNotifyExample.class.wait();
        }
    }

    // синхронизирован по WaitNotifyExample.class
    private static synchronized void example2() {

    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
