package ru.geekbrains.classes.internal;

import ru.geekbrains.classes.Participant;

public class Main {

    public static class StaticInternal {
        public int value;
    }

    public class Internal {

    }

    public static void main(String[] args) {
        StaticInternal staticInternal = new StaticInternal();
        Internal internal = new Main().new Internal();

        class Internal1 {

        }

        Participant participant = new Participant() {

            @Override
            public boolean isOnDistance() {
                return false;
            }

            @Override
            public void run(int distance) {

            }

            @Override
            public void jump(int height) {

            }

            @Override
            public void swim(int distance) {

            }
        };
    }
}
