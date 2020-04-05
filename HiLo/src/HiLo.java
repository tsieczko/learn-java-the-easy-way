import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String playAgain = "";
		int randomNumber = (int) (Math.random() * 200 - 100 + 1);
		int guess = 0;

		do {
			while (guess != randomNumber) {
				System.out.print("Guess a number between -100 and 100: ");
				guess = scanner.nextInt();

				if (guess < randomNumber) {
					System.out.println(guess + " is too low. Try again.");
				}
				if (guess > randomNumber) {
					System.out.println(guess + " is too high. Try again.");
				}
				if (guess == randomNumber) {
					System.out.println(guess + " is correct. You win!");
				}
			}

			System.out.println("Would you like to play again (y/n)?");
			playAgain = scanner.next();
		} while (playAgain.equalsIgnoreCase("y"));

		System.out.println("Thank you for playing! Goodbye.");
		scanner.close();
	}

}
