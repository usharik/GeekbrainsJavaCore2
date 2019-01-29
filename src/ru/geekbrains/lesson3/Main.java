package ru.geekbrains.lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 0, 3, 4};
        int[] arr2 = new int[5];
        int[] tmp = new int[10];

        // Проблема увеличения размера массива в Java
        System.arraycopy(arr2, 0, tmp, 0, arr2.length);
        arr2 = extendArray(arr2);

        // ArrayList - реализует массив, размер которого динамически увеличивается
        // при необходимости
        ArrayList<Integer> list = new ArrayList<>(); // Integer[] list;
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<String> strList = new ArrayList<>(); // String[] strlist;
        strList.add("Строка 1");
        strList.add("Строка 2");
        strList.add("Строка 3");

        System.out.printf("list[0] = %d%n", list.get(0));

        if (list.contains(1)) {
            System.out.println("Значение 1 есть в списке");
        }

        if (list.contains(10)) {
            System.out.println("Значение 10 есть в списке");
        }

        for (Integer val : list) {
            // вызов в этом месте remove() приведет к ошибке
            System.out.println(val);
        }

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // Будет существенно менее производительна чем ArrayList
        linkedList.get(2);

        // LinkedList следует использовать если нужен стек или очередь
        Deque<Integer> queue = new LinkedList<>();

        Set<Integer> setOfInt = new HashSet<>();
        setOfInt.add(1);
        setOfInt.add(2);
        setOfInt.add(3);
        setOfInt.add(3); // все равно во множестве будет три элемента

        // Одинаковые значения, но разные адреса в памяти
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);

        // сравниваются адреса объектов в памяти
        // в большинстве случаев это не верно
        if (i1 == i2) {
            System.out.println("Числа равны");
        }

        // сравниваются значения
        if (i1.equals(i2)) {
            System.out.println("Числа равны");
        }

        // когда нужно сохранить порядок добавления элементов
        Set<Integer> linkedSet = new LinkedHashSet<>();

        // Условия корректности для метода equals
        // 1. a.equals(a) == true
        // 2. a.equals(b) == true => b.equals(a)
        // 3. a.equals(b) && b.equals(c) => a.equals(c)

        // Условия корректности для метода hashCode
        // 1. a.equals(b)  => a.hashCode() == b.hashCode()
        // 2. !a.equals(b) => a.hashCode() == b.hashCode() || a.hashCode() != b.hashCode()

        // hashCode = 1 ???

        // Поиск элемента за время O(log(n))
        Set<Integer> treeSet = new TreeSet<>();
        setOfInt.add(1);
        setOfInt.add(2);
        setOfInt.add(3);
        setOfInt.add(3);

        Map<String, String[]> dict = new HashMap<>();
        dict.put("dot", new String[] {"точка"});
        dict.put("comma", new String[] {"запятая"});
        dict.put("language", new String[] {"язык"});

        dict.get("dot");
        dict.containsKey("dot"); // быстрый
        dict.containsValue("запятая"); // медленный
    }

    /**
     * Единственный способ в Java увеличить длинну массива
     * @param arr
     * @return
     */
    public static int[] extendArray(int[] arr) {
        int[] tmp = new int[arr.length * 2];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        return tmp;
    }
}
