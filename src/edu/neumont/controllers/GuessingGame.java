package edu.neumont.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessingGame {

    private final BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    private boolean gameStarted;
    private int maximum;

    public void play() {
        Random random = new Random();
        int randomNumber;
        System.out.println("Select a difficulty: Easy, Medium, Hard: ");
        try {

            do {
                String userInput = scanner.readLine();
                switch (userInput) {
                    case "Easy":
                    case "E":
                        maximum = 10;
                        gameStarted = true;
                        break;
                    case "Medium":
                    case "M":
                        maximum = 50;
                        gameStarted = true;
                        break;
                    case "Hard":
                    case "H":
                        maximum = 100;
                        gameStarted = true;
                        break;
                    default:
                        System.out.println("Select a difficulty: Easy, Medium, Hard");
                        break;
                }

            } while (!gameStarted);

            randomNumber = random.nextInt(maximum) + 1;
            System.out.println("Guess a number between 1 and " + maximum);
            int userGuess = Integer.parseInt(scanner.readLine());

            do {
                if (userGuess > randomNumber) {
                    System.out.println("You guessed to high! Try again.");
                } else if (userGuess < randomNumber) {
                    System.out.println("You guessed to low! Try again.");
                }
                System.out.println("Guess a number between 1 and " + maximum);
                userGuess = Integer.parseInt(scanner.readLine());
            } while (userGuess != randomNumber);

            System.out.println("You won! The random number was " + randomNumber);
        } catch (Exception exception) {
            System.out.println("Exception: " + exception);
        }
    }
}
