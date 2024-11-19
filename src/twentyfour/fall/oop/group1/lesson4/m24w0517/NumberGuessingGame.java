package twentyfour.fall.oop.group1.lesson4.m24w0517;

import java.util.Random;
import java.util.Scanner;

/**
 * Id: M24W0517
 * Name: Dilan Nawarthna
 * Assignment: KCGI/OOP
 * Note for professor: -
 */
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = random.nextInt(100) + 1;
        byte[] guesses = new byte[10];
        int validAttempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Guess the number (between 1 and 100):");

        for (int i = 0; i < 10; ) {  // Only increments on valid attempts
            int guess = scanner.nextInt();

            // Check if guess is valid
            if (guess < 1 || guess > 100) {
                System.out.println("Invalid guess. Try a number between 1 and 100.");
                continue; // Skip to the next iteration without incrementing i
            }

            // Store valid guess
            guesses[validAttempts] = (byte) guess;
            validAttempts++;
            i++;

            // Check if the guess is correct, too high, or too low
            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the right number in " + validAttempts + " attempts!");
                guessedCorrectly = true;
                break;
            } else if (guess > targetNumber) {
                System.out.println("Too high.");
            } else {
                System.out.println("Too low.");
            }
        }

        // If out of guesses and number not guessed
        if (!guessedCorrectly) {
            System.out.println("Game over! The correct number was " + targetNumber + ".");
        }

        // Display all valid guesses
        System.out.print("Your guesses were: [");
        for (int j = 0; j < validAttempts; j++) {
            System.out.print(guesses[j]);
            if (j < validAttempts - 1) System.out.print(", ");
        }
        System.out.println("]");

        scanner.close();
    }
}
