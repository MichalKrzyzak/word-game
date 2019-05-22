package com.myproject;

import java.util.Scanner;

class Controller {
    void runProgram() {
        Scanner input = new Scanner(System.in);
        System.out.println("~~Welcome to word game!~~\nChoose what you want to do:\n1 - enter letters and get all possible polish words\n2 - play the game in which you will have to create as many words as you can from random letters\nEnter \"q\" or \"exit\" to quit.");

        String userInput = input.nextLine();

    }

    private void verifyUserInput(String userInput) {

    }
}
