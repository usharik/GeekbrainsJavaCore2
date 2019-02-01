package ru.geekbrains.lesson3;

import java.util.*;

public class PhoneBook {
    private Map<String, Contact> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addPhoneNumber(String name, String phoneNumber) {
        Contact contact;
        String key = name.toUpperCase();
        if (phoneBook.containsKey(key)) {
            contact = phoneBook.get(key);
        } else {
            contact = new Contact(name);
            phoneBook.put(key, contact);
        }
        contact.addPhoneNumber(phoneNumber);
    }

    public List<String> get(String name) {
        String key = name.toUpperCase();
        if (!phoneBook.containsKey(key)) {
            return Collections.EMPTY_LIST;
        }
        return phoneBook.get(key).getPhoneNumbers();
    }
}
