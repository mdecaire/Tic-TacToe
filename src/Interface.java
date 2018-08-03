import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	JFrame frame = new JFrame("Tic-Tac-Toe");

	private void initComponents() {


		JLabel TitleLabel = new JLabel("Welcome to Tic-Tac-Toe");
		TitleLabel.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 2, 18));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setForeground(new java.awt.Color(255, 51, 204));
		
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();

		
		zero = new JButton();
		zero.setBorder(raisedbevel);
		zero.setBackground(new Color(51, 153, 255));
		zero.addActionListener(e -> setPlayerSelected(zero, 0));
		one = new JButton();
		one.setBorder(raisedbevel);
		one.setBackground(new Color(51, 153, 255));
		one.addActionListener(e -> setPlayerSelected(one, 1));
		two = new JButton();
		two.setBorder(raisedbevel);
		two.setBackground(new Color(51, 153, 255));
		two.addActionListener(e -> setPlayerSelected(two, 2));
		three = new JButton();
		three.setBorder(raisedbevel);
		three.setBackground(new Color(51, 153, 255));
		three.addActionListener(e -> setPlayerSelected(three, 3));
		four = new JButton();
		four.setBorder(raisedbevel);
		four.setBackground(new Color(51, 153, 255));
		four.addActionListener(e -> setPlayerSelected(four, 4));
		five = new JButton();
		five.setBorder(raisedbevel);
		five.setBackground(new Color(51, 153, 255));
		five.addActionListener(e -> setPlayerSelected(five, 5));
		six = new JButton();
		six.setBorder(raisedbevel);
		six.setBackground(new Color(51, 153, 255));
		six.addActionListener(e -> setPlayerSelected(six, 6));
		seven = new JButton();
		seven.setBorder(raisedbevel);
		seven.setBackground(new Color(51, 153, 255));
		seven.addActionListener(e -> setPlayerSelected(seven, 7));
		eight = new JButton();
		eight.setBorder(raisedbevel);
		eight.setBackground(new Color(51, 153, 255));
		eight.addActionListener(e -> setPlayerSelected(eight, 8));

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel(new GridLayout(4, 1));
		contentPane.setPreferredSize(new Dimension(350, 400));
		JPanel TitlePanel = new JPanel(new GridLayout(6, 1));
		TitlePanel.add(new JPanel());
		TitlePanel.add(TitleLabel, BorderLayout.CENTER);
		TitlePanel.add(new JPanel());
		TitlePanel.add(new JPanel());

		TitlePanel.add(new JPanel());
		JLabel instructions = new JLabel("Click on a Box to Play");
		instructions.setFont(new java.awt.Font("Tw Cen MT Condensed ", 1, 14));
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		TitlePanel.add(instructions);

		contentPane.add(TitlePanel);
		contentPane.add(new JPanel());

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

	private void setPlayerSelected(JButton btn, int num) {
		int numberToSign = num;
		btn.setText("X");
		btn.setBackground(Color.white);
		setPlayerInformation(numberToSign);
	}

	private void setPlayerInformation(int numberToSign) {

		String btnName = player.setPlayerGrid(numberToSign, frame);
		if (btnName.equals("Game Over")) {
		resetGame();
		}
		changeBtn(btnName);
		if (player.checkComp(frame)) {
			resetGame();
		}
		return;
	}

	private void resetGame() {
		player=new PlayerLogic();
		zero.setText("");
		zero.setBackground(new Color(51, 153, 255));
		one.setText("");
		one.setBackground(new Color(51, 153, 255));
		two.setText("");
		two.setBackground(new Color(51, 153, 255));
		three.setText("");
		three.setBackground(new Color(51, 153, 255));
		four.setText("");
		four.setBackground(new Color(51, 153, 255));
		five.setText("");
		five.setBackground(new Color(51, 153, 255));
		six.setText("");
		six.setBackground(new Color(51, 153, 255));
		seven.setText("");
		seven.setBackground(new Color(51, 153, 255));
		eight.setText("");
		eight.setBackground(new Color(51, 153, 255));
	}

	public static void main(String[] args) {
		Interface player = new Interface();
		player.initComponents();
	}
}