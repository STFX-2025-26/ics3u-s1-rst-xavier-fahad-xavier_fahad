package fahadJavaCode;

import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;

public class Word_Scramble {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String[] wordBank = new String[] {"galaxy", "puzzle", "whisper", "lantern", "orbit", "cactus", "thunder", "marble", "voyage", "crystal", "shadow", "ember", "compass", "ripple", "rocket", "mirror"};
	int rand = (int)(Math.random() * wordBank.length);
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Word_Scramble window = new Word_Scramble();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Word_Scramble() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 518, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Word Scrambler");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(53, 11, 418, 58);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(119, 115, 308, 58);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(119, 238, 308, 58);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Your guess:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 203, 138, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Unscramble this:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 80, 138, 41);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String randWord = wordBank[rand];
				char[] letters = randWord.toCharArray();
				Random rund = new Random();
				
				for (int i = letters.length - 1; i > 0; i--) {
				    int j = rund.nextInt(i + 1); // pick a random index
				    
				    // Swap letters[i] and letters[j]
				    char temp = letters[i];
				    letters[i] = letters[j];
				    letters[j] = temp;
				}
				String ScrambledWord = new String(letters);
				textField.setText(ScrambledWord);
				
			}
		});
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(196, 300, 111, 36);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userGuess = textField_1.getText();
				userGuess = userGuess.toLowerCase();
				
				
				if (userGuess.equals(wordBank[rand])) {
					textField_2.setBackground(Color.GREEN);
					textField_2.setText("Good guess !!!");
				}
				
				else {
					textField_2.setBackground(Color.RED);
					textField_2.setText("Try Again :( ");
				}
				
			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerate.setBounds(196, 184, 111, 36);
		frame.getContentPane().add(btnGenerate);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(341, 194, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
