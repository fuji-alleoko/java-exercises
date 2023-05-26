package Exercise10;

import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        int targetNumber = generateTargetNumber();
        int numberOfGuesses = 0;
        boolean guessedCorrectly = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have 3 guesses to find the target number.");
        System.out.println("The target number is between 1 and 10.");

        while (numberOfGuesses < 3) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            numberOfGuesses++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                guessedCorrectly = true;
                break;
            } else if (guess < targetNumber) {
                System.out.println("Higher!");
            } else {
                System.out.println("Lower!");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you couldn't guess the number. The target number was: " + targetNumber);
        }

        scanner.close();
    }

    private static int generateTargetNumber() {
        return (int) (Math.random() * 10) + 1;
    }
}