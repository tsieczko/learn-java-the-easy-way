import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int randomNumber = (int) (Math.random() * 100 + 1);
		int guess = 0;
		
		while (guess != randomNumber) {
			System.out.print("Guess a number between 1 and 100: ");
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
	}

}
