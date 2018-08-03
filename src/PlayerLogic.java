import java.util.ArrayList;

import javax.swing.JFrame;



public class PlayerLogic {
    String level="easy";
    char[] playerGrid= new char[9];
    ComputerLogic cL= new ComputerLogic();
   
    
    public void setLevel(String level){
        this.level=level;
    }
  

    public String setPlayerGrid(int num, JFrame frame) {
        playerGrid[num]='X';
        if(cL.isThereAWinner(playerGrid, frame)){
			return ("Game Over");
		}
        String computerMove=getRemainingMoves(frame);
        return computerMove;
    }


	private String getRemainingMoves(JFrame frame ) {
		ArrayList<Integer> emptySlots=new ArrayList<Integer>();
		for(int i=0;i<playerGrid.length; i++) {
			if(playerGrid[i]==0) {
				emptySlots.add(i);	
			}
		}
		String computerMove=cL.pickAMove(frame,emptySlots,level, playerGrid);
		return computerMove;
	}


	public boolean checkComp(JFrame frame) {
		boolean winner=cL.isThereAWinner(playerGrid, frame);
		return winner;
	}


	
}

