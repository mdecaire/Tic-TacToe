import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ComputerLogic {
	String btnName = "";
	boolean winner=false;

	public String pickAMove(JFrame frame, String diff, ArrayList<Integer> emptySlots, char[] playerGrid) {

		int num = emptySlots.size();
		if (num == 0) {
			if (!isThereAWinner(playerGrid)) {
				JOptionPane.showMessageDialog(frame, "Cat Game! No Winner!", "No Winner", JOptionPane.PLAIN_MESSAGE);
			}
			return "Game Over";
		}
		if (diff.equals("medium")) {
			playMedium(playerGrid, emptySlots, num);

		} else {
			Random ran = new Random();
			int slotNumber = ran.nextInt(num);
			int index = (int) emptySlots.get(slotNumber);
			playerGrid[index] = 'O';
			btnName = Integer.toString(index);
		}
		return btnName;
	}

	private void playMedium(char[] playerGrid, ArrayList<Integer> emptySlots, int num) {

	if(checkforWin(playerGrid)) {
		return;
	}else if(canBlock(playerGrid)) {
		return;
	}else {
			Random ran = new Random();
			int slotNumber = ran.nextInt(num);
			int index = (int) emptySlots.get(slotNumber);
			playerGrid[index] = 'O';
			btnName = Integer.toString(index);
		}
	
	}

	private boolean canBlock(char[] playerGrid) {
	boolean blockMove=false;
	for(int i=0; i<playerGrid.length; i++) {
		blockMove=false;
		if(playerGrid[i]==0) {
			playerGrid[i]='X';
			blockMove=isThereAWinner(playerGrid);
			if(blockMove) {
				playerGrid[i]='O';
				btnName=Integer.toString(i);
				break;
			}else {
				playerGrid[i]=0;
			}
		}
	}
	winner=false;
	return blockMove;
	}

	private boolean checkforWin(char[] playerGrid) {
		boolean winningMove=false;
		for(int i=0; i<playerGrid.length; i++) {
			winningMove=false;
			if(playerGrid[i]==0) {
				playerGrid[i]='O';
				winningMove=isThereAWinner(playerGrid);
				if(winningMove) {
					btnName=Integer.toString(i);
					break;
				}else {
					playerGrid[i]=0;
				}
			}
		}
		winner=false;
		return winningMove;
	}

	
	int playerScore = 0;
	int compScore = 0;

	public boolean isThereAWinner(char[] playerGrid ) {

		 winner = false;

		for (int i = 0; i < 3; i++) {

			addPlayerScores(playerGrid, i);

		}

		winner = checkStatus();
		resetScores();
		if (!winner) {

			for (int i = 3; i <= 5; i++) {

				addPlayerScores(playerGrid, i);

			}

			winner = checkStatus();

			resetScores();

		}

		if (!winner) {

			for (int i = 6; i <= 8; i++) {

				addPlayerScores(playerGrid, i);

			}

			winner = checkStatus();

			resetScores();

		}

		if (!winner) {

			for (int i = 0; i <= 8; i += 4) {

				addPlayerScores(playerGrid, i);

			}

			winner = checkStatus();

			resetScores();

		}

		if (!winner) {

			for (int i = 2; i <= 8; i += 2) {

				addPlayerScores(playerGrid, i);

			}

			winner = checkStatus();

			resetScores();

		}

		if (!winner) {

			for (int i = 0; i <= 6; i += 3) {

				addPlayerScores(playerGrid, i);

			}

			winner = checkStatus();

			resetScores();

		}

		if (!winner) {

			for (int i = 1; i <= 7; i += 3) {

				addPlayerScores(playerGrid, i);

			}

			winner = checkStatus();

			resetScores();

		}

		if (!winner) {

			for (int i = 2; i <= 8; i += 3) {

				addPlayerScores(playerGrid, i);

			}

			winner = checkStatus();

			resetScores();

		}

		return winner;

	}

	private void resetScores() {

		playerScore = 0;

		compScore = 0;

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

	boolean compWins = false;
	boolean playerWins = false;

	private boolean checkStatus() {

		boolean winner = false;

		if (compScore == 15) {

			winner = true;
			compWins = true;

		}

		else if (playerScore == 15) {

			winner = true;

			playerWins = true;

		}

		return winner;

	}
}
