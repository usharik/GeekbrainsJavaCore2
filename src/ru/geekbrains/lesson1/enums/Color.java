package ru.geekbrains.lesson1.enums;

public enum Color {
    BLACK("черный"),
    WHITE("белый"),
    GREEN("зеленый"),
    RED("красный"),
    BLUE("синий");

    public String ruName;
    public int coloreCode;

    Color(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
