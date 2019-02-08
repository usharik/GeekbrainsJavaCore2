package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SharedValueExample {

    private static int counter = 0;

    private static synchronized void incrementCounter() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementer = new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i=0; i<10; i++) {
                    // считать значение
                    // увеличить значение на единицу
                    // записать
                    incrementCounter();
                }
            }
        };

        List<Thread> threadList = new ArrayList<>();

        for (int i=0; i<10; i++) {
            Thread thr = new Thread(incrementer);
            threadList.add(thr);
            thr.start();
        }

        for (Thread thr : threadList) {
            thr.join();
        }

        System.out.println(counter);

        // потокозащещенная коллекция
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
    }
}
