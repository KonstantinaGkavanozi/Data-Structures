//information and personal data are included in the report
public class Game {
	
	int round;
	
	public Game(){
		round=0;
		
	}
	
	public int getRound() {
		return round;
	}
	
	public void setRound(int round) {
		this.round=round;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int numberOfSupplies;
		
		Board board= new Board();
		Game game=new Game();
		
		board.setN(15);
		
		board.setS(4);
		
		board.setW(338);
		
		board.createBoard();
		
		int round=game.getRound();
		Player theseus= new Player(1,"T",board,0,0,0);
		Player minotaur= new Player(2,"M",board,0,7,7);
		
		int theseusId=0;
		int minotaurId=112;
		board.getStringRepresentation(theseusId, minotaurId);
		
		
		
		
		for(round=0;round<200;round++) {
			numberOfSupplies=0;
			for(int i=0;i<board.getS();i++) {
				//counting the number of the supplies that are collected
				if(board.supplies[i].getX()==0 && board.supplies[i].getY()==0) {
					numberOfSupplies++;
					if(numberOfSupplies==4) {
						System.out.println("Theseus wins!");
						break;
					}
					else
						continue;
				}	
			}
			
			if(round%2==0) {
				theseusId=theseus.move(theseusId)[0];
			}
			else {
				minotaurId=minotaur.move(minotaurId)[0];
				
			}
			
			System.out.println("Round :" +round);
			board.getStringRepresentation(theseusId, minotaurId);
			if(theseusId==minotaurId) {
				System.out.println("Minotaur wins!");
				break;
			}
			
			
		
		}
		if(round==200) {
			System.out.println("It's a tie!");
		}
		
	}
}
		
	

		
		
		
		
		
	
		
	

