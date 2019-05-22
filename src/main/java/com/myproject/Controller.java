package com.myproject;

import java.util.Scanner;

class Controller {
    void runProgram() {
        System.out.println("~~Welcome to word game!~~");
        gatherUserChoice();
    }

    private void gatherUserChoice() {
        System.out.println("Choose what you want to do:\n1 - enter letters and get all possible polish words\n2 - play the game in which you will have to create as many words as you can from random letters\nEnter \"q\" or \"exit\" to quit.");
        verifyUserInput(new Scanner(System.in).nextLine());
    }

    private void verifyUserInput(String userInput) {
        if (isUserInputGame(userInput)) {
            System.out.println("Game starts...");
            gatherUserChoice();
        } else if (isUserInputGenerator(userInput)) {
            System.out.println("Generating words...");
            gatherUserChoice();
        } else if (isUserInputQuit(userInput)) {
            System.out.println("Exiting...");
            System.exit(0);
        } else {
            System.out.println("Oops! Wrong input. Try again!");
            gatherUserChoice();
        }
    }

    private boolean isUserInputQuit(String userInput) {
        return (userInput.equalsIgnoreCase("q") || userInput.equalsIgnoreCase("exit"));
    }

    private boolean isUserInputGenerator(String userInput) {
        return userInput.equalsIgnoreCase("1");
    }

    private boolean isUserInputGame(String userInput) {
        return userInput.equalsIgnoreCase("2");
    }
}
