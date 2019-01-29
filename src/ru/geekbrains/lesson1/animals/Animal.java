package ru.geekbrains.lesson1.animals;

import ru.geekbrains.lesson1.Participant;

public abstract class Animal implements Participant {

    private String name;
    private boolean onDistance;
    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;

    public Animal(String name, int maxRunDistance,
                  int maxJumpHeight, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public String getName() {
        return name;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public abstract void voice();

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " успешно пробежал кросс");
        } else {
            System.out.println(name + " не справился с кроссом");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " успешно перепрыгнул стену");
        } else {
            System.out.println(name + " не справился с прыжком");
            onDistance = false;
        }
    }

    @Override
    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " не умеет плавать");
            onDistance = false;
        } else if (distance <= maxSwimDistance) {
            System.out.println(name + " успешно переплыл");
        } else {
            System.out.println(name + " не смог переплыть");
            onDistance = false;
        }
    }

    @Override
    public String toString() {
        return name + " : " + (isOnDistance() ? "на дистанции" : "сошел с дистанции");
    }
}
