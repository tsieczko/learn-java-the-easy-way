import java.util.Scanner;

public class CeasarCipher {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String message = "";
		String output = ""; 
		int key = 13;
		
		try {
			System.out.println("Enter a key (-25 to 25): ");
			key = Integer.parseInt(scanner.nextLine());
			
			System.out.println("Enter a message to encode or decode: ");
			message = scanner.nextLine();
			
			for (char letter : message.toCharArray()) {
				output += encodeCharacter(letter, key);
			}
			
			System.out.println(output);
		} catch (Exception e) {
			System.out.println("Error decoding message.");
		}

		scanner.close();
	}
	
	public static char encodeCharacter(char letter, int key) {
		if (letter >= 'A' && letter <= 'Z') {
			letter += key;
			if (letter > 'Z') {
				letter -= 26;
			}
			if (letter < 'A') {
				letter += 26;
			}
		}
		if (letter >= 'a' && letter <= 'z') {
			letter += key;
			if (letter > 'z') {
				letter -= 26;
			}
			if (letter < 'a') {
				letter += 26;
			}
		}
		if (letter >= '0' && letter <= '9') {
			letter += key;
			if (letter > '9') {
				letter -= 10;
			}
			if (letter < '0') {
				letter += 10;
			}
		}
		
		return letter;
	}

}
