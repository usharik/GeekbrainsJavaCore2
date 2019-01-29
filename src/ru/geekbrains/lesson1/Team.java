package ru.geekbrains.lesson1;

public class Team {

    private final String name;

    private final Participant[] participants;

    public Team(String name, Participant ...participants) {
        this.name = name;
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void getResults() {
        System.out.printf("Итоги для комманды %s:%n", name);
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }
}
