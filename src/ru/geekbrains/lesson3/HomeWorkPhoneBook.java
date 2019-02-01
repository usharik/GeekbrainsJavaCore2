package ru.geekbrains.lesson3;

public class HomeWorkPhoneBook {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneNumber("Ваня", "123");
        phoneBook.addPhoneNumber("Петя", "456");
        phoneBook.addPhoneNumber("Петя", "7777778");
        phoneBook.addPhoneNumber("Сережа", "7777778");

        System.out.println(phoneBook.get("Ваня"));
        System.out.println(phoneBook.get("Петя"));
        System.out.println(phoneBook.get("Петр"));
    }
}
