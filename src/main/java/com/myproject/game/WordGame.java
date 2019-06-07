package com.myproject.game;

import com.myproject.WordSplitter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class WordGame implements WordSplitter {
    private final Scanner input1 = new Scanner(System.in);
    private int userPoints = 0;
    private final List<Character> generatedCharacters;

    WordGame(List<Character> generatedCharacters) {
        this.generatedCharacters = generatedCharacters;
    }

    void fetchUserWord() {
        String userWord = input1.nextLine();

        if (!userWord.equalsIgnoreCase("that's all")) {
            verifyUserWord(userWord);
        } else {
            endGame();
        }

    }

    private void verifyUserWord(String userWord) {
        if (canWordBeAccepted(userWord)) {
            userPoints++;
            System.out.println("Good job! Go on...");
            fetchUserWord();
        } else {
            System.out.println("This word is not correct! Try another one.");
            fetchUserWord();
        }
    }

    private void endGame() {
        if (userPoints > 0) {
            System.out.println("Good job! You earned " + userPoints + " points!");
        } else {
            System.out.println("Unfortunately you didn't score any points :( Better luck next time!");
        }
    }

    private boolean canWordBeAccepted(String userWord) {
        List<Character> userWordChars = wordToCharArray(userWord.toLowerCase());
        return generatedCharacters.containsAll(userWordChars) && isUserWordReal(userWord);
    }

    private boolean isUserWordReal(String userWord) {
        boolean isWordReal = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\resources\\words.txt"))) {
            while (bufferedReader.readLine() != null) {
                if (bufferedReader.readLine().equalsIgnoreCase(userWord)) {
                    isWordReal = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (NullPointerException ignored) {
        }

        return isWordReal;
    }
}
