import java.util.Random;
import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String playAgain = "";
		Random rand = new Random();

		do {
			// Random number between -100 and 100
			int randomNumber = rand.nextInt(201) - 100;
			int guess = 0;
			int numTries = 0;
			
			while (guess != randomNumber) {
				System.out.print("Guess a number between -100 and 100: ");
				guess = scanner.nextInt();
				numTries++;

				if (guess < randomNumber) {
					System.out.println(guess + " is too low. Try again.");
				}
				if (guess > randomNumber) {
					System.out.println(guess + " is too high. Try again.");
				}
				if (guess == randomNumber) {
					System.out.println(guess + " is correct. You win!");
					System.out.println("It only took you " + numTries + " tries! Good work!");
				}
			}

			System.out.print("Would you like to play again? (y/n): ");
			playAgain = scanner.next();
		} while (playAgain.equalsIgnoreCase("y"));

		System.out.println("Thank you for playing! Goodbye.");
		scanner.close();
	}

}
