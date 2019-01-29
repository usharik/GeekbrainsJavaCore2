package ru.geekbrains.lesson2.exceptions;

public class HomeWork2 {

    public static void main(String[] args) {
        String[][] arr = {{"1", "2", "3", "4"},
                {"1", "21", "3", "55fff"},
                {"13", "2", "34", "4"},
                {"1", "22", "3", "4"}};

        try {
            System.out.println("Сумма значений в массиве = "
                    + calcArraySum(arr));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int calcArraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j=0; j<arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j, arr[i][j], ex);
                }
            }
        }

        return sum;
    }
}
