import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ComputerLogic {

	public String pickAMove(JFrame frame, ArrayList<Integer> emptySlots, String level, char[] playerGrid) {

		String myMove = "";
		if (level.equals("easy")) {
			myMove = playEasy(playerGrid, emptySlots, frame);
		}
		return myMove;
	}

	private String playEasy(char[] playerGrid, ArrayList<Integer> emptySlots, JFrame frame) {
		int num = emptySlots.size();
		if (num == 0) {
			if (!isThereAWinner(playerGrid, frame)) {
				JOptionPane.showMessageDialog(frame, "Cat Game! No Winner!", "No Winner", JOptionPane.PLAIN_MESSAGE);
			}
			return "Game Over";
		}
		Random ran = new Random();
		int slotNumber = ran.nextInt(num);
		int index = (int) emptySlots.get(slotNumber);
		playerGrid[index] = 'O';
		String btnName = Integer.toString(index);
		return btnName;
	}

	int compScore = 0;
	int playerScore = 0;

	public boolean isThereAWinner(char[] playerGrid, JFrame frame) {
		boolean winner = false;
		for (int i = 0; i < 3; i++) {
			addPlayerScores(playerGrid, i);
		}
		winner = checkStatus(frame);
		if (!winner) {
			for (int i = 3; i <= 5; i++) {
				addPlayerScores(playerGrid, i);
			}
			winner = checkStatus(frame);
			resetScores();
		}
		if (!winner) {
			for (int i = 6; i <= 8; i++) {
				addPlayerScores(playerGrid, i);
			}

			winner = checkStatus(frame);
			resetScores();
		}
		if (!winner) {
			for (int i = 0; i <= 8; i += 4) {
				addPlayerScores(playerGrid, i);
			}
			winner = checkStatus(frame);
			resetScores();
		}
		if (!winner) {
			for (int i = 2; i <= 8; i += 2) {
				addPlayerScores(playerGrid, i);
			}

			winner = checkStatus(frame);
			resetScores();
		}
		if (!winner) {
			for (int i = 0; i <= 6; i += 3) {
				addPlayerScores(playerGrid, i);
			}
			winner = checkStatus(frame);
			resetScores();
		}
		if (!winner) {
			for (int i = 1; i <= 7; i += 3) {
				addPlayerScores(playerGrid, i);
			}
			winner = checkStatus(frame);
			resetScores();
		}
		if (!winner) {
			for (int i = 2; i <= 8; i += 3) {
				addPlayerScores(playerGrid, i);
			}
			winner = checkStatus(frame);
			resetScores();
		}
		
		return winner;
	}

	private void resetScores() {
		playerScore=0;
		compScore=0;
		
	}

	private void addPlayerScores(char[] playerGrid, int i) {
		
		int[] magicBoard = new int[] { 8, 1, 6, 3, 5, 7, 4, 9, 2 };
		if (playerGrid[i] == 'X') {
			playerScore += magicBoard[i];
		}
		if (playerGrid[i] == 'O') {
			compScore += magicBoard[i];
		}
	}

	private boolean checkStatus(JFrame frame) {
		boolean winner = false;
		if (compScore == 15) {
			winner = true;
			showWinnerDialog("I", frame);
		}
		else if (playerScore == 15) {
			winner = true;
			showWinnerDialog("You", frame);
		}
		return winner;
	}

	private void showWinnerDialog(String string, JFrame frame) {
		JOptionPane.showMessageDialog(frame, string + " win!", "Winner", JOptionPane.PLAIN_MESSAGE);

	}
}
