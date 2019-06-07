package com.myproject.generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FileParser {

    void gatherAllWords(List<Character> userChars) {
        HashMap<Character, Integer> countedUserInput = countChars(userChars);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\words.txt"))) {
            while (bufferedReader.readLine() != null) {
                String word = bufferedReader.readLine();
                List<Character> characterList = wordToCharArray(word);
                if (userChars.containsAll(characterList)) {
                    HashMap<Character, Integer> wordCounted = countChars(characterList);
                    if (canWordBeCreated(wordCounted, countedUserInput)) {
                        System.out.println(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {
        }
    }

    private boolean canWordBeCreated(HashMap<Character, Integer> wordChars, HashMap<Character, Integer> userChars) {

        for (Map.Entry<Character, Integer> entry : wordChars.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            Integer userCharsNumber = userChars.get(key);
            if (userCharsNumber == null || value > userCharsNumber) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> countChars(List<Character> userChars) {

        HashMap<Character, Integer> userInput = new HashMap<>();
        for (Character c : userChars) {
            Integer key = userInput.get(c);
            if (key != null) {
                userInput.put(c, key + 1);
            } else {
                userInput.put(c, 1);
            }
        }
        return userInput;
    }

    private List<Character> wordToCharArray(String word) {
        return word.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());
    }

}
