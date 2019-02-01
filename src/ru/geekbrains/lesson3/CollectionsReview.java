package ru.geekbrains.lesson3;

import java.util.*;

public class CollectionsReview {

    public static void main(String[] args) {

        // List - списки

        // Динамический массив
        List<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");

        // быстро
        arrayList.get(0);

        // медленно
        arrayList.add(0, "bbb");

        // медленно (просмотр всего массива)
        arrayList.contains("bbb");

        // Двусвязный список
        LinkedList<String> linkedList = new LinkedList<>();
        arrayList.add("aaa");

        // медленно
        arrayList.get(2);

        // быстро работают методы двунаправленной очереди стека
        Deque<String> deque = linkedList;

        // Set - множества
        // Элементы множества должны быть уникальны
        // У элементов должен быть корректно переопределен equals и hashCode
        Set<String> hashSet = new HashSet<>();
        hashSet.add("bbb");

        // быстро
        // !!! Не итерируйте Set для поиска элемента
        hashSet.contains("bbb");

        // Элементы будут уникальны и отсортированны
        // Элементы должны имплементировать интерфейс Comparable
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("ccc");

        // Сохраняет порядок добавления элементов
        Set<String> linkedHashSet = new LinkedHashSet<>();

        // Map - структура ключ -> значение
        Map<String, String> dictionary = new HashMap<>();

        // быстрый поиск по ключу
        dictionary.get("bbb");

        // медленно
        dictionary.containsValue("aaa");

        dictionary = new LinkedHashMap<>();

        dictionary = new TreeMap<>();
    }
}
