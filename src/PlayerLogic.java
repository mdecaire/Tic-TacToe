import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PlayerLogic {
	char[] playerGrid = new char[9];
	ComputerLogic cL = new ComputerLogic();
	String diff = "";

	//defaults to easy level
	PlayerLogic() {
		this.diff = "easy";
	}

	//sets the difficult level
	public void setLevel(String string) {
		this.diff = string;

	}

	//sets the players move ...the checks for win
	//initializes computer to move
	public String setPlayerGrid(int num, JFrame frame) {
		playerGrid[num] = 'X';
		if (checkPlayer(frame)) {
			return ("Game Over");
		} else {
			String computerMove = getRemainingMoves(frame);
			return computerMove;
		}

	}

	//calls Computer logic to see if there is a winner 
	private boolean checkPlayer(JFrame frame) {
		if (cL.isThereAWinner(playerGrid, 'X')) {
			showWinnerDialog("You", frame);
			return true;
		}
		return false;
	}

	//collects all the remaining moves for the board
	//calls computer to make a move
	private String getRemainingMoves(JFrame frame) {
		ArrayList<Integer> emptySlots = new ArrayList<Integer>();
		for (int i = 0; i < playerGrid.length; i++) {//finds all the empty slots
			if (playerGrid[i] == 0) {
				emptySlots.add(i);
			}
		}
		String computerMove = cL.pickAMove(frame, diff, emptySlots, playerGrid);
		return computerMove;
	}

	//calls computer logic to see whether
	public boolean checkComp(JFrame frame) {
		boolean winner = cL.isThereAWinner(playerGrid, 'O');
		if (winner) {
			showWinnerDialog("I", frame);
		}
		return winner;
	}

	private void showWinnerDialog(String string, JFrame frame) {
		JOptionPane.showMessageDialog(frame, string + " win!", "Winner", JOptionPane.PLAIN_MESSAGE);

	}

	//makes sure player is not selecting an already chosen grid
	public boolean wrongButton(int numberToSign) {
		if (playerGrid[numberToSign] != 0) {
			return true;
		}
		return false;
	}

}
