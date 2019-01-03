import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ComputerLogic {
	String btnName = "";
	boolean winner=false;

	/**
	 * Only gets to here if player is not a winner
	 * @param frame
	 * @param diff difficulty level
	 * @param emptySlots how many slots are still available
	 * @param playerGrid Moves that have already been played
	 * @return
	 */
	public String pickAMove(JFrame frame, String diff, ArrayList<Integer> emptySlots, char[] playerGrid) {

		int num = emptySlots.size();
		if (num == 0) {
			if (!isThereAWinner(playerGrid,'X')||!isThereAWinner(playerGrid,'O')) {
				JOptionPane.showMessageDialog(frame, "Cat Game! No Winner!", "No Winner", JOptionPane.PLAIN_MESSAGE);
			}
			return "Game Over";
		}
		if (diff.equals("medium")) { //goes to medium level
			playMedium(playerGrid, emptySlots, num);

		} else {//easy level...just randomly selects the next move on the board
			Random ran = new Random();
			int slotNumber = ran.nextInt(num);
			int index = (int) emptySlots.get(slotNumber);
			playerGrid[index] = 'O';
			btnName = Integer.toString(index);
		}
		return btnName;
	}

	/**
	 * initializes the medium level...which checks to see if 
	 * player or computer has a winning move
	 * @param playerGrid
	 * @param emptySlots
	 * @param num
	 */
	private void playMedium(char[] playerGrid, ArrayList<Integer> emptySlots, int num) {

	if(isNextMoveTheWinningMove(playerGrid,'O')) {//checks to see if it has a winning move
		return;
	}else if(isNextMoveTheWinningMove(playerGrid,'X')) {//checks to see if player has a winning move
		return;
	}else {//randomly selects a next move if there are no apparent winning moves
			Random ran = new Random();
			int slotNumber = ran.nextInt(num);
			int index = (int) emptySlots.get(slotNumber);
			playerGrid[index] = 'O';
			btnName = Integer.toString(index);
		}
	
	}

	/**
	 * this method iterates through the player grid to 
	 * see if there are any moves that will be winning moves.
	 * It does this by filling in hypothetical plays
	 * to see if they are winners
	 * @param playerGrid
	 * @param symbol
	 * @return
	 */
	private boolean isNextMoveTheWinningMove(char[] playerGrid, char symbol) {
		boolean winningMove=false;
		for(int i=0; i<playerGrid.length; i++) {
			winningMove=false;
			if(playerGrid[i]==0) {
				playerGrid[i]=symbol;
				winningMove=isThereAWinner(playerGrid, symbol);
				if(winningMove) {
					playerGrid[i]='O'; //ensures that computer blocks player moves or takes it's own move
					btnName=Integer.toString(i);
					break;
				}else {
					playerGrid[i]=0;
				}
			}
		}
		winner=false;//makes sure that winner is not set prematurely from hypothetical moves
		return winningMove;
	}

	
	/**
	 * iterates through comparing the player grid  to the winning combinations
	 * to see if there is a winner so far
	 * @param playerGrid is the list of all the moves made so far
	 * @param symbol is either X for player or O for computer
	 * @return boolean if there is a winner
	 */
	public boolean isThereAWinner(char[] playerGrid, char symbol ) {
		int[][] winningCombinations= new int[][] {
			{0,1,2},//first row
			{3,4,5},//second row
			{6,7,8},//third row
			{0,3,6},//first col
			{1,4,7},//second col
			{2,5,8},//third col
			{0,4,8},//left diag
			{2,4,6}//right diag
		};
		for(int i=0; i<8; i++) {
			winner=true;
			for(int j=0; j<3; j++) {
				int index=winningCombinations[i][j];
				if(playerGrid[index]!=symbol) {
					winner=false;
					break;//breaks out of inner loop if no winner in this row
				}
			}
			if(winner==true) {//breaks out of outer loop if there is a winner
				break;
			}
		}
		
		return winner;
	}

	

}
