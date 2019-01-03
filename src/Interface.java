import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Interface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PlayerLogic player = new PlayerLogic();
	private JButton zero;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	JRadioButton easy = new JRadioButton("Easy");
	JRadioButton med = new JRadioButton("Medium");
	JFrame frame = new JFrame("Tic-Tac-Toe");
	Color pinkish = new Color(153, 51, 204);

	//initializes the interface
	private void initComponents() {

		JLabel TitleLabel = new JLabel("Welcome to Tic-Tac-Toe");
		TitleLabel.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 2, 18));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(pinkish);

		easy.setSelected(true);
		easy.addActionListener(e -> setDifficulty("easy"));
		med.addActionListener(e -> setDifficulty("medium"));
		ButtonGroup radio = new ButtonGroup();
		radio.add(easy);
		radio.add(med);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();

		zero = new JButton();
		zero.setBorder(raisedbevel);
		zero.setBackground(pinkish);
		zero.addActionListener(e -> setPlayerSelected(zero, 0));
		one = new JButton();
		one.setBorder(raisedbevel);
		one.setBackground(pinkish);
		one.addActionListener(e -> setPlayerSelected(one, 1));
		two = new JButton();
		two.setBorder(raisedbevel);
		two.setBackground(pinkish);
		two.addActionListener(e -> setPlayerSelected(two, 2));
		three = new JButton();
		three.setBorder(raisedbevel);
		three.setBackground(pinkish);
		three.addActionListener(e -> setPlayerSelected(three, 3));
		four = new JButton();
		four.setBorder(raisedbevel);
		four.setBackground(pinkish);
		four.addActionListener(e -> setPlayerSelected(four, 4));
		five = new JButton();
		five.setBorder(raisedbevel);
		five.setBackground(pinkish);
		five.addActionListener(e -> setPlayerSelected(five, 5));
		six = new JButton();
		six.setBorder(raisedbevel);
		six.setBackground(pinkish);
		six.addActionListener(e -> setPlayerSelected(six, 6));
		seven = new JButton();
		seven.setBorder(raisedbevel);
		seven.setBackground(pinkish);
		seven.addActionListener(e -> setPlayerSelected(seven, 7));
		eight = new JButton();
		eight.setBorder(raisedbevel);
		eight.setBackground(pinkish);
		eight.addActionListener(e -> setPlayerSelected(eight, 8));

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel(new GridLayout(3, 1));
		contentPane.setPreferredSize(new Dimension(350, 400));
		JPanel TitlePanel = new JPanel(new GridLayout(8, 1));
		JPanel radPanel = new JPanel(new GridLayout(1, 4));
		radPanel.add(new JLabel());
		radPanel.add(easy);
		radPanel.add(med);
		radPanel.add(new JLabel());

		TitlePanel.add(new JPanel());
		TitlePanel.add(TitleLabel, BorderLayout.CENTER);
		TitlePanel.add(new JPanel());
		JLabel diff = new JLabel("Choose your level of difficulty");
		diff.setFont(new java.awt.Font("Tw Cen MT Condensed ", 1, 14));
		diff.setHorizontalAlignment(SwingConstants.CENTER);
		TitlePanel.add(diff);
		JLabel instructions = new JLabel("& Click on a Box to Play");
		instructions.setFont(new java.awt.Font("Tw Cen MT Condensed ", 1, 14));
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		TitlePanel.add(instructions);
		TitlePanel.add(new JPanel());
		TitlePanel.add(radPanel);
		TitlePanel.add(new JPanel());
		contentPane.add(TitlePanel);

		JPanel btnPanel = new JPanel(new GridLayout(3, 3, 5, 5));
		btnPanel.setBackground(Color.BLACK);
		btnPanel.add(zero);
		btnPanel.add(one);
		btnPanel.add(two);
		btnPanel.add(three);
		btnPanel.add(four);
		btnPanel.add(five);
		btnPanel.add(six);
		btnPanel.add(seven);
		btnPanel.add(eight);

		JPanel pan = new JPanel(new GridLayout(1, 3));
		pan.add(new JLabel(""));
		pan.add(btnPanel);
		pan.add(new JLabel(""));
		contentPane.add(pan);

		frame.setContentPane(contentPane);
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	//sets the difficulty level of the game
	private void setDifficulty(String string) {
		player.setLevel(string);
	}

	/*
	 * changes the buttons for the computer
	 * since the computer has no action events
	 */
	private void changeBtn(String btnName) {
		switch (btnName) {
		case "0":
			zero.setText("O");
			zero.setBackground(Color.white);
			break;
		case "1":
			one.setText("O");
			one.setBackground(Color.white);
			break;
		case "2":
			two.setText("O");
			two.setBackground(Color.white);
			break;
		case "3":
			three.setText("O");
			three.setBackground(Color.white);
			break;
		case "4":
			four.setText("O");
			four.setBackground(Color.white);
			break;
		case "5":
			five.setText("O");
			five.setBackground(Color.white);
			break;
		case "6":
			six.setText("O");
			six.setBackground(Color.white);
			break;
		case "7":
			seven.setText("O");
			seven.setBackground(Color.white);
			break;
		case "8":
			eight.setText("O");
			eight.setBackground(Color.white);
			break;
		default:
			return;
		}

	}

	//sets the buttons when the player makes a move
	private void setPlayerSelected(JButton btn, int num) {
		if (player.wrongButton(num)) {
			JOptionPane.showMessageDialog(frame, "Button already Selected", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		btn.setText("X");
		btn.setBackground(Color.white);
		setPlayerInformation(num);
	}

	//determines if the game is over and resets the board
	private void setPlayerInformation(int numberToSign) {

		String btnName = player.setPlayerGrid(numberToSign, frame);
		if (btnName.equals("Game Over")) {
			resetGame();
		}
		changeBtn(btnName);
		//computer was checked for winner here...because otherwise the "O" does
		//not show up before the computer declares itself a winner
		if (player.checkComp(frame)) {
			resetGame();
		}
		return;

	}

	//code to actually reset the board
	private void resetGame() {
		player = new PlayerLogic();
		zero.setText("");
		zero.setBackground(pinkish);
		one.setText("");
		one.setBackground(pinkish);
		two.setText("");
		two.setBackground(pinkish);
		three.setText("");
		three.setBackground(pinkish);
		four.setText("");
		four.setBackground(pinkish);
		five.setText("");
		five.setBackground(pinkish);
		six.setText("");
		six.setBackground(pinkish);
		seven.setText("");
		seven.setBackground(pinkish);
		eight.setText("");
		eight.setBackground(pinkish);
		if (med.isSelected()) {
			player.setLevel("medium");
		}
	}

	public static void main(String[] args) {
		Interface player = new Interface();
		player.initComponents();
	}
}
