import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Using random function
        Random random = new Random();
        
        // define the range of the number guess
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalRounds = 10;
        int totalScore = 0;
        
        // display first welcome message
        System.out.println();
        System.out.println("Welcome to the Number Game!");
        
        for (int round = 1; round <= totalRounds; round++) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            // Showing the user number of round
            System.out.println("\nRound " + round + ":");
            
            // Printing the range
            System.out.println("Guess the random number between " + minRange + " and " + maxRange);
            
            // using while loop 
            while (attempts < maxAttempts) {
                System.out.println();
                System.out.print("Attempt " + (attempts + 1) + ": "); //display attempts
                int guess = scanner.nextInt();
                
                if (guess < targetNumber) {
                    System.out.println("Too low!"); //if the guess number is low
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");  // if the guess number is high
                } else {
                    // if user guess the correct number
                    System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                    totalScore += maxAttempts - attempts;
                    break;
                }
                attempts++;
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Out of attempts. The number was: " + targetNumber);
            }

            //Asking the user did he want to continue the game

            System.out.print("Do you want to play again? (Y/N): ");
            String playAgain = scanner.next();
            if (playAgain.equalsIgnoreCase("N")) {
                break;
            }
        }
        
        // Game over & we exit from loop
        System.out.println("\nGame over! Your total score is: " + totalScore);
        System.out.println("Thank you for playing!");
        
        scanner.close();
    }
}
