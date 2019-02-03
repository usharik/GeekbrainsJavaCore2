package ru.geekbrains.lesson4;

public class Message {

    private String userName;

    private String message;

    public Message(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }
}
