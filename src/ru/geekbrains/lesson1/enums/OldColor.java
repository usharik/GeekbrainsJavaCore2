package ru.geekbrains.lesson1.enums;

public final class OldColor {

    public static final OldColor RED = new OldColor("красный");
    public static final OldColor GREEN = new OldColor("зеленый");

    private String ruName;

    private OldColor(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
