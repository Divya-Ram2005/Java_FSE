import java.util.Random;
import java.util.Scanner;

public class numberdesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1;  // Random number from 1 to 100
        int guess = 0;

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100:");

        // Loop until the correct guess
        while (guess != numberToGuess) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println(" Congratulations! You guessed the number correctly!");
            }
        }

        sc.close();
    }
}