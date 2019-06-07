package com.myproject;

import com.myproject.game.LetterGenerator;
import com.myproject.generator.LetterCollector;

import java.util.Scanner;

class Controller {
    private final Scanner input = new Scanner(System.in);

    void runProgram() {
        System.out.println("~~Welcome to word game!~~");
        gatherUserChoice();
    }

    private void gatherUserChoice() {
        System.out.println("Choose what you want to do:\n1 - enter letters and get all possible polish words\n2 - play the game in which you will have to create as many words as you can from random letters\nEnter \"q\" or \"exit\" to quit.");
        verifyUserInput(input.nextLine());
    }

    private void verifyUserInput(String userInput) {
        if (isUserInputGame(userInput)) {
            new LetterCollector().runGame();
            askIfAgain();
        } else if (isUserInputGenerator(userInput)) {
            new LetterGenerator().runGame();
            askIfAgain();
        } else if (isUserInputQuit(userInput)) {
            exitProgram();
        } else {
            System.out.println("Oops! Wrong input. Try again!");
            gatherUserChoice();
        }
    }

    private void askIfAgain() {
        System.out.println("Do you want to run program again? Y/N");
        String userInput = input.nextLine();
        if (doRunAgain(userInput)) {
            gatherUserChoice();
        } else {
            exitProgram();
        }

    }

    private void exitProgram() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    private boolean isUserInputQuit(String userInput) {
        return (userInput.equalsIgnoreCase("q") || userInput.equalsIgnoreCase("exit"));
    }

    private boolean isUserInputGame(String userInput) {
        return userInput.equalsIgnoreCase("1");
    }

    private boolean isUserInputGenerator(String userInput) {
        return userInput.equalsIgnoreCase("2");
    }

    private boolean doRunAgain(String userInput) {
        return userInput.equalsIgnoreCase("y");
    }
}
