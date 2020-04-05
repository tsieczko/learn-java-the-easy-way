import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField textGuess;
	private JLabel lblOutput;
	private JButton btnPlayAgain;
	private int randomNumber;
	private int numTries;

	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Hi-Lo Guessing Game");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 38, 414, 19);
		getContentPane().add(lblTitle);

		JLabel lblInput = new JLabel("Guess a number between 1 and 100:");
		lblInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInput.setBounds(10, 95, 256, 14);
		getContentPane().add(lblInput);

		textGuess = new JTextField();
		textGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		textGuess.setBounds(276, 92, 86, 20);
		textGuess.setColumns(10);
		getContentPane().add(textGuess);

		JButton guessButton = new JButton("Guess");
		guessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		guessButton.setBounds(161, 147, 112, 23);
		getContentPane().add(guessButton);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 208, 414, 14);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnPlayAgain.setBounds(161, 174, 112, 23);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
	}

	public void checkGuess() {
		String guessText = textGuess.getText();
		String message = "";
		int guess = 0;

		try {
			numTries++;
			guess = Integer.parseInt(guessText);

			if (guess < randomNumber) {
				message = guess + " is too low. Try again.";
			}
			if (guess > randomNumber) {
				message = guess + " is too high. Try again.";
			}
			if (guess == randomNumber) {
				message = guess + " is correct. You win! It only took you " + numTries + " tries.";
				btnPlayAgain.setVisible(true);
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			textGuess.requestFocus();
			textGuess.selectAll();
		}
	}

	public void newGame() {
		numTries = 0;
		randomNumber = (int) (Math.random() * 100 + 1);
		btnPlayAgain.setVisible(false);
		lblOutput.setText("Enter a number above and click Guess!");
	}
}
