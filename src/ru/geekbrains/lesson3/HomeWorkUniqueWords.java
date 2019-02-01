package ru.geekbrains.lesson3;

import java.util.*;

public class HomeWorkUniqueWords {

    public static void main(String[] args) {
        String[] words = {"word", "word2", "word", "word1",
                "word2", "word", "word1", "ttt", "ttt",
                "letter", "sun", "color", "sun"};

        List<String> wordsList = Arrays.asList(words);
        Map<String, Integer> result = new HashMap<>();

        for (String word : wordsList) {
            result.put(word, Collections.frequency(wordsList, word));
        }

        System.out.println(result);

        result = new HashMap<>();
        for (String word : wordsList) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
                continue;
            }
            result.put(word, 1);
        }

        System.out.println(result);
    }
}
