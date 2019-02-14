package ru.geekbrains.lesson4.swing;

import java.time.LocalDate;

public class Message {

    private String userFrom;

    private String userTo;

    private String text;

    private LocalDate date;

    public Message(String userFrom, String userTo, String text) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.text = text;
        this.date = LocalDate.now();
    }

    public String getUserFrom() {
        return userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }
}
