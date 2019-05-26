package com.myproject.generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class FileParser {
    void gatherAllWords(List<Character> userChars) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\words.txt"))) {
            while (bufferedReader.readLine() != null) {
                String word = bufferedReader.readLine();
                if (userChars.containsAll(wordToCharArray(word))) {
                    System.out.println(word);
                }
                //TODO distinct number of characters so there won't be repetitions of character that occurs once.
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {
        }
    }

    private List<Character> wordToCharArray(String word) {
        return word.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }
}
