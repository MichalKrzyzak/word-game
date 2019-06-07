package com.myproject.game;

import java.util.Scanner;
import java.util.stream.Collectors;

public class LetterCollector {

    public void runGame() {
        askForLetters();
    }

    private void askForLetters() {
        System.out.println("Enter your letters below splitting them by \",\":");
        fetchLetters();
    }

    private void fetchLetters() {
        Scanner input = new Scanner(System.in);
        String userLetters = input.nextLine().replace(", ", "");
        new FileParser()
                .gatherAllWords(userLetters.chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toList()));
    }
}
