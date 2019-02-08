package ru.geekbrains.lesson4.swing;

import java.time.LocalDate;

public class Message {

    private String userName;

    private String message;

    private LocalDate date;

    public Message(String userName, String message) {
        this.userName = userName;
        this.message = message;
        this.date = LocalDate.now();
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getDate() {
        return date;
    }
}
