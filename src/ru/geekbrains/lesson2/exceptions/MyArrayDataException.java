package ru.geekbrains.lesson2.exceptions;

public class MyArrayDataException extends Exception {

    private int rowIndex;
    private int colIndex;
    private String value;

    public MyArrayDataException(int rowIndex, int colIndex, String value) {
        this(rowIndex, colIndex, value, null);
    }

    public MyArrayDataException(int rowIndex, int colIndex, String value, Throwable cause) {
        super(String.format("В ячейке массива [%d][%d] некорректное значени %s",
                rowIndex, colIndex, value), cause);
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.value = value;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public String getValue() {
        return value;
    }
}
