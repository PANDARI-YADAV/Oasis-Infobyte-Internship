import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to 'Guess the Number' Game!");

        while (playAgain) {
            rounds++;
            int maxAttempts = 5;
            int attempts = 0;
            int score = 0;

            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;

            System.out.println("\nRound " + rounds + ": Guess the number between 1 and 100!");
            System.out.println("You have " + maxAttempts + " attempts.");

            boolean guessedCorrectly = false;
            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Attempt " + attempts + "/" + maxAttempts + ": Enter your guess: ");
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    System.out.println("You must enter a number! Try again.");
                    attempts--;
                    continue;
                }

                int userGuess;
                try {
                    userGuess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    attempts--;
                    continue;
                }

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;
                    System.out.println("Congratulations! You guessed the number correctly.");
                    System.out.println("Score for this round: " + score);
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Game Over! You've used all attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Round " + rounds + " complete!");
            System.out.println("Your total score is: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            if (!playAgain) {
                System.out.println("Thank you for playing! Your final score is: " + totalScore);
            }
        }

        scanner.close();
    }
}
