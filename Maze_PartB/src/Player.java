import java.util.Random;

public class Player {
	  	int playerId;
	    String name;
	    Board board;
	    int score;
	    int x;
	    int y;


	    public Player(){
	        playerId = 0;
	        name = " ";
	        board = new Board();
	        score = 0;
	        x = 0;
	        y = 0;
	    }

	    public Player(int playerId,String name,Board board,int score,int x,int y){
	        this.playerId = playerId;
	        this.name = name;
	        this.board = board;
	        this.score = score;
	        this.x = x;
	        this.y = y;
	    }

	    public int getPlayerId() {
	        return playerId;
	    }

	    public void setPlayerId(int playerId) {
	        this.playerId = playerId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Board getBoard() {
	        return board;
	    }

	    public void setBoard(Board board) {
	        this.board = board;
	    }

	    public int getScore() {
	        return score;
	    }

	    public void setScore(int score) {
	        this.score = score;
	    }

	    public int getX() {
	        return x;
	    }

	    public void setX(int x) {
	        this.x = x;
	    }

	    public int getY() {
	        return y;
	    }

	    public void setY(int y) {
	        this.y = y;
	    }
	    
	    int [] move (int id) {
	    	int movement;
	    	
	    	int[] playerArray=new int [4];
	    	do {
	    		movement = new Random().nextInt(7)+1;//1<movement<7
	    	}while(movement%2==0);
	    	
	    	switch(movement) {
	    	
	    	case 1:
	    		if(board.tiles[id].getUp()==true) {
	    			if(getPlayerId()==1)
	    				System.out.println("Theseus can't move up! You lose your turn");
	    			else if(getPlayerId()==2)
	    				System.out.println("Minotaur can't move up! You lose your turn");
	    			break;
	    		}
	    			
	    		else {
	    			id+=board.getN();
	    			if(getPlayerId()==1) {
	    				System.out.println("Theseus moves up!");
	    			}
	    				
	    			else if(getPlayerId()==2) {
	    				System.out.println("Minotaur moves up!");
	    			}
	    			
	    			
	    			break;
	    		}
	    	
	    	case 3:
	    		if(board.tiles[id].getRight()==true) {
	    			if(getPlayerId()==1)
	    				System.out.println("Theseus can't move right! You lose your turn");
	    			else if(getPlayerId()==2)
	    				System.out.println("Minotaur can't move right! You lose your turn");
	    			break;
	    		}
	    			
	    		else {
	    			id+=1;
	    			if(getPlayerId()==1)
	    				System.out.println("Theseus moves right!");
	    			else if(getPlayerId()==2)
	    				System.out.println("Minotaur moves right!");
		    		break;
	    		}
	    			
	    	
	    	case 5:
	    		if(board.tiles[id].getDown()==true) {
	    			if(getPlayerId()==1)
	    				System.out.println("Theseus can't move down! You lose your turn");
	    			else if(getPlayerId()==2)
	    				System.out.println("Minotaur can't move down! You lose your turn");
	    			break;
	    		}
	    			
	    		else {
	    			id-=board.getN();
	    			if(getPlayerId()==1)
	    				System.out.println("Theseus moves down!");
	    			else if(getPlayerId()==2)
	    				System.out.println("Minotaur moves down!");
	    			
		    		break;
	    		}
	    			
	    	
	    	case 7:
	    		if(board.tiles[id].getLeft()==true) {
	    			if(getPlayerId()==1)
	    				System.out.println("Theseus can't move left! You lose your turn");
	    			else if(getPlayerId()==2)
	    				System.out.println("Minotaur can't move left! You lose your turn");
	    			break;
	    		}
	    		else {
	    			id-=1;
	    			if(getPlayerId()==1)
	    				System.out.println("Theseus moves left!");
	    			else if(getPlayerId()==2)
	    				System.out.println("Minotaur moves left!");
		    		break;
	    		}
	    			
	    	}
	    	for(int i=0;i<board.getS();i++) {
	    		//since only Theseus (player 1) can collect supplies we check if Theseus is the active player  
	    		if(board.supplies[i].supplyTileId==id && playerId==1) {
	    			System.out.println("Theseus found the supply s" + i+1);
	    			playerArray[0]=id;
	    	    	playerArray[1]=board.tiles[id].x;
	    	    	playerArray[2]=board.tiles[id].y;
	    			playerArray[3]=board.supplies[i].supplyId;
	    			board.supplies[i].supplyTileId=0;
	    	    	board.supplies[i].x=0;
	    	    	board.supplies[i].y=0;
	    	    	
	    	    	
	    		}
	    		else {
	    			playerArray[0]=id;
	    	    	playerArray[1]=board.tiles[id].x;
	    	    	playerArray[2]=board.tiles[id].y;
	    			playerArray[3]=0;
	    			
	    		}
	    			
	    	}
	    	
	    	return playerArray;
	    	
	    }
}
