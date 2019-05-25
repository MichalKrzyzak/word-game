package com.myproject.generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class FileParser {
    void gatherAllWords(List<Character> userChars) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\words.txt"))) {
            String word;
            while (bufferedReader.readLine() != null) {
                word = bufferedReader.readLine();
                if (wordToCharArray(word).equals(userChars)) {
                    System.out.println(word);
                }
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
