package com.myproject;

import java.util.List;
import java.util.stream.Collectors;

public interface WordSplitter {
    default List<Character> wordToCharArray(String word) {
        return word.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }
}
