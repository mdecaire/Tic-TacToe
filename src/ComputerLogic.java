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
			if (!isThereAWinner(playerGrid,'X')||!isThereAWinner(playerGrid,'O')) {
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

	if(checkforWin(playerGrid,'O')) {
		return;
	}else if(checkforWin(playerGrid,'X')) {
		return;
	}else {
			Random ran = new Random();
			int slotNumber = ran.nextInt(num);
			int index = (int) emptySlots.get(slotNumber);
			playerGrid[index] = 'O';
			btnName = Integer.toString(index);
		}
	
	}

	

	private boolean checkforWin(char[] playerGrid, char symbol) {
		boolean winningMove=false;
		for(int i=0; i<playerGrid.length; i++) {
			winningMove=false;
			if(playerGrid[i]==0) {
				playerGrid[i]=symbol;
				winningMove=isThereAWinner(playerGrid, symbol);
				if(winningMove) {
					playerGrid[i]='O'; //ensures block
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

	
	
	public boolean isThereAWinner(char[] playerGrid, char symbol ) {
		winner=true;
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
					break;
				}
			}
			if(winner==true) {
				break;
			}
		}
		
		return winner;
	}

	

}
