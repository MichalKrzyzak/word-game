package com.myproject.game;

import com.myproject.WordSplitter;

import java.util.Scanner;

class WordGame implements WordSplitter {
    private final Scanner input1 = new Scanner(System.in);
    private int userPoints = 0;

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
        
    }
}
