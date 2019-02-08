package ru.geekbrains.lesson5;


public class DaemonThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread completed");
            }
        });
        thread.setDaemon(true);
        thread.start();

        System.out.println("Main thread completed.");
    }
}
