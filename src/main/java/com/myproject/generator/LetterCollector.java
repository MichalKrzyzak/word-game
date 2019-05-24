package com.myproject.generator;

import java.util.Scanner;
import java.util.stream.Collectors;

public class LetterCollector {
    public void askForLetters() {
        System.out.println("Enter your letters below splitting them by \",\":");
        fetchLetters();
    }

    private void fetchLetters() {
        Scanner input = new Scanner(System.in);
        String userLetters = input.nextLine();
        new FileParser()
                .gatherAllWords(userLetters.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList()));
    }
}
