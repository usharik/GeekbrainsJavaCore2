package ru.geekbrains.lesson5;

public class App {

    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                App.sleep(10);
                System.out.printf("Thread id %d counter %d%n", getId(), i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread(); // поток создан, но не запущен
        myThread.start(); // !!! не забудьте вызвать метод start для запуска

        new Thread() {

            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    App.sleep(10);
                    System.out.printf("Thread id %d counter %d%n", getId(), i);
                }
            }
        }.start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    App.sleep(10);
                    System.out.printf("Thread id %d counter %d%n",
                            Thread.currentThread().getId(), i);
                }
            }
        }).start();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
