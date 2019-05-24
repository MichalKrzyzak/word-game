package com.myproject.generator;

import java.util.Arrays;
import java.util.Scanner;

public class LetterCollector {
    public void askForLetters() {
        System.out.println("Enter your letters below splitting them by \",\":");
        fetchLetters();
    }

    private void fetchLetters() {
        Scanner input = new Scanner(System.in);
        String userLetters = input.nextLine();
        new FileParser().gatherAllWords(Arrays.asList(userLetters.split(",")));
    }
}
