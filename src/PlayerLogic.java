import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class PlayerLogic {
    char[] playerGrid= new char[9];
    ComputerLogic cL= new ComputerLogic();
    String diff="";
    
    PlayerLogic(){
    this.diff="easy";	
    }
    public void setLevel(String string) {
		this.diff=string;
		
	}

    public String setPlayerGrid(int num, JFrame frame) {
        playerGrid[num]='X';
       if(checkPlayer(frame)) {
    	   return ("Game Over");
       }else {
    	   
           String computerMove=getRemainingMoves(frame);
           return computerMove; 
       }
       
    }


	private boolean checkPlayer(JFrame frame) {
		if(cL.isThereAWinner(playerGrid)){
        	showWinnerDialog("You", frame);
			return true;
		}
		return false;
	}
	private String getRemainingMoves(JFrame frame ) {
		ArrayList<Integer> emptySlots=new ArrayList<Integer>();
		for(int i=0;i<playerGrid.length; i++) {
			if(playerGrid[i]==0) {
				emptySlots.add(i);	
			}
		}
		String computerMove=cL.pickAMove(frame,diff,emptySlots,playerGrid);
		return computerMove;
	}


	public boolean checkComp(JFrame frame) {
		boolean winner=cL.isThereAWinner(playerGrid);
		if(winner) {
			showWinnerDialog("I", frame);	
		}
		return winner;
	}


	
	private void showWinnerDialog(String string, JFrame frame) {
		JOptionPane.showMessageDialog(frame, string + " win!", "Winner", JOptionPane.PLAIN_MESSAGE);

	}
	public boolean wrongButton(int numberToSign) {
		if(playerGrid[numberToSign]=='X') {
			return true;
		}
		return false;
	}


	
}

