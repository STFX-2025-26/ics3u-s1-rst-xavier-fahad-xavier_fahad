package fahadJavaCode;
import javax.swing.ImageIcon;
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
	ImageIcon myPicture2 = new ImageIcon(getClass().getResource("/fahadJavaCode/PartyPopper3.PNG"));
	String[] wordBank = new String[] {"galaxy", "puzzle", "whisper", "lantern", "orbit", "cactus", "thunder", "marble", "voyage", "crystal", "shadow", "ember", "compass", "ripple", "rocket", "mirror"};
	int rand;
	String currentWord;
	
	private JTextField textField_2;
	private JLabel lblNewLabel;
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(184, 123, 308, 58);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBounds(184, 238, 308, 58);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Your guess:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 214, 138, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel PicLabel = new JLabel("");
		PicLabel.setToolTipText("");
		PicLabel.setIcon(new ImageIcon(Word_Scramble.class.getResource("/fahadJavaCode/Unscrambler2.png")));
		PicLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		PicLabel.setBounds(124, 0, 276, 139);
		frame.getContentPane().add(PicLabel);
		
		JButton btnCheckButton = new JButton("Check");
		btnCheckButton.setEnabled(false);
		btnCheckButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCheckButton.setBounds(194, 307, 111, 36);
		frame.getContentPane().add(btnCheckButton);
		btnCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				currentWord = wordBank[rand];
				String userGuess = textField_1.getText();
				userGuess = userGuess.toLowerCase();
				
				if (userGuess.equals(currentWord)) {
					textField_2.setBackground(Color.GREEN);
					textField_2.setText("Good guess !!!");
					
					lblNewLabel.setIcon(myPicture2);
				}
				
				else {
					textField_2.setBackground(Color.RED);
					textField_2.setText("Try Again :( ");
				}
				
			}
		});
		
		JButton btnReavealButton = new JButton("Reveal");
		btnReavealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_1.setText(currentWord);
				
			}
		});
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// "reset the GUI"
				lblNewLabel.setIcon(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_2.setBackground(Color.WHITE);
				btnCheckButton.setEnabled(true);
				btnReavealButton.setEnabled(true);
				
				// generate randome index of worbank
				rand = (int)(Math.random() * wordBank.length);
				
				// separate word into characters array(letters)
				currentWord = wordBank[rand];
				char[] letters = currentWord.toCharArray();
				Random rund = new Random();
				
				for (int i = letters.length - 1; i > 0; i--) {
				    int j = rund.nextInt(i + 1); // pick a random index
				    
				    // Swap letters[i] and letters[j]
				    char temp = letters[i];
				    letters[i] = letters[j];
				    letters[j] = temp;
				}
				
				// display randomly generated and scrambled word
				String ScrambledWord = new String(letters);
				textField.setText(ScrambledWord);
				
			}
		});
		
		btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerate.setBounds(194, 191, 111, 36);
		frame.getContentPane().add(btnGenerate);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(361, 201, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Unscramble this:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(23, 131, 138, 41);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(23, 253, 125, 90);
		frame.getContentPane().add(lblNewLabel);
		
		btnReavealButton.setEnabled(false);
		btnReavealButton.setBounds(347, 320, 89, 23);
		frame.getContentPane().add(btnReavealButton);
		
		JLabel lblNewLabel_2 = new JLabel("Only after 2 trys.");
		lblNewLabel_2.setBounds(347, 306, 128, 13);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
