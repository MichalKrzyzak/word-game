package com.myproject.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LetterGenerator {
    private final Random random = new Random();

    public void runGame() {
        System.out.println("Try to find as many words as possible from the letters below. If you can't think of anything else, type \"that's all\".\nRandomly generated letters:\n" + generateLetters());
        new WordGame().fetchUserWord();
    }

    private String generateLetters() {
        List<String> alphabetLetters = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "W", "Z");
        List<String> generatedLetters = new ArrayList<>();

        int numberOfLetters = random.nextInt(5) + 4;

        for (int i = 0; i < numberOfLetters; i++) {
            String randomLetter = alphabetLetters.get(random.nextInt(alphabetLetters.size()));
            generatedLetters.add(randomLetter.toLowerCase());
        }

        return generatedLetters.toString();
    }

}