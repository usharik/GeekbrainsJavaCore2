package ru.geekbrains.classes;

import ru.geekbrains.classes.animals.Cat;
import ru.geekbrains.classes.animals.Dog;
import ru.geekbrains.classes.obstacles.*;

public class Application {

    public static void main(String[] args) {

        Course course = new Course(new Cross(5),
                new Wall(3),
                new Water(7));

        Team team = new Team("Super team",
                new Cat("Барсик", 10, 12, 0),
                new Dog("Дружок", 20, 5, 15),
                new Cat("Мурзик", 9, 14, 0),
                new Robot("Вертер", 50, 50, 50));

        course.doIt(team);

        team.getResults();
    }
}