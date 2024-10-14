import java.util.ArrayList;


public class HeuristicPlayer extends Player {
	ArrayList<Integer[]> path;
	
	public HeuristicPlayer() {
		super();
		path = new ArrayList<Integer[]>();
	}
	
	public HeuristicPlayer(int playerId,String name,Board board,int score,int x,int y, int n ) {
		//n is the number of the rounds
		super(playerId,name,board,score,x,y);
		path = new ArrayList<Integer[]>(n);
		
	}
	
	public double evaluate(int currentPos, int dice,int minotaurTile) {
		double purpose=0;
		double supplyDis=0, opponentDis=0;
		int N=board.getN();
		
		//checking the number of the dice
		if(dice==1) {
			//checking if there is a wall north
			if(board.tiles[currentPos].getUp()==false) {
				//checking if we are within the borders of the array
				if(currentPos+N<N*N) {
					//checking if the minotaur is on the tile that is located north
					if(board.tiles[minotaurTile].getTileId()==currentPos+N) {
						opponentDis=-1;
					}
					for(int i=0; i<board.getS();i++) {
						//checking if there is a supply on the tile that is located north
						if(board.tiles[currentPos+N].getTileId()==board.supplies[i].getSupplyTileId()) {
							supplyDis=1;
						}
						
					}
					//doing the same checks for the tile above the previous one
					if(board.tiles[currentPos+N].getUp()==false) {
						if(currentPos+2*N<N*N) {
							if(board.tiles[minotaurTile].getTileId()==currentPos+2*N) {
								opponentDis=-1/2;
							}
							for(int i=0; i<board.getS();i++) {
								if(board.tiles[currentPos+2*N].getTileId()==board.supplies[i].getSupplyTileId()) {
									supplyDis=1/2;
								}
							}
							if(board.tiles[currentPos+2*N].getUp()==false) {
								if(currentPos+3*N<N*N) {
									if(board.tiles[minotaurTile].getTileId()==currentPos+3*N) {
										opponentDis=-1/3;
									}
									for(int i=0;i<board.getS();i++) {
										if(board.tiles[currentPos+3*N].getTileId()==board.supplies[i].getSupplyTileId()) {
											supplyDis=1/3;
										}
									}
								}
							}
						}
					}
				}
			}
			
			
		}
		//following the pattern from the previous if for the tiles located right
		else if(dice==3) {
			if(board.tiles[currentPos].getRight()==false) {
				if(currentPos+1<N*N) {
					if(board.tiles[minotaurTile].getTileId()==currentPos+1) {
						opponentDis=-1;
					}
					for(int i=0; i<board.getS();i++) {
						if(board.tiles[currentPos+1].getTileId()==board.supplies[i].getSupplyTileId()) {
							supplyDis=1;
						}
						
					}
					if(board.tiles[currentPos+1].getRight()==false) {
						if(currentPos+2<N*N) {
							if(board.tiles[minotaurTile].getTileId()==currentPos+2) {
								opponentDis=-1/2;
							}
							for(int i=0; i<board.getS();i++) {
								if(board.tiles[currentPos+2].getTileId()==board.supplies[i].getSupplyTileId()) {
									supplyDis=1/2;
								}
							}
							if(board.tiles[currentPos+2].getRight()==false) {
								if(currentPos+3<N*N) {
									if(board.tiles[minotaurTile].getTileId()==currentPos+3) {
										opponentDis=-1/3;
									}
									for(int i=0;i<board.getS();i++) {
										if(board.tiles[currentPos+3].getTileId()==board.supplies[i].getSupplyTileId()) {
											supplyDis=1/3;
										}
									}
								}
							}
						}
					}
					
				}
				
			}
			
			
		}
		//following the same pattern as before for the tiles located down
		else if(dice==5) {
			if(board.tiles[currentPos].getDown()==false) {
				if(currentPos-N>0) {
					if(board.tiles[minotaurTile].getTileId()==currentPos-N) {
						opponentDis=-1;
					}
					for(int i=0; i<board.getS();i++) {
						if(board.tiles[currentPos-N].getTileId()==board.supplies[i].getSupplyTileId()) {
							supplyDis=1;
						}
						
					}
					if(board.tiles[currentPos-N].getDown()==false) {
						if(currentPos-2*N<N*N) {
							if(board.tiles[minotaurTile].getTileId()==currentPos-2*N) {
								opponentDis=-1/2;
							}
							for(int i=0; i<board.getS();i++) {
								if(board.tiles[currentPos-2*N].getTileId()==board.supplies[i].getSupplyTileId()) {
									supplyDis=1/2;
								}
								
							}
							if(board.tiles[currentPos-2*N].getDown()==false) {
								if(currentPos-3*N>0) {
									if(board.tiles[minotaurTile].getTileId()==currentPos-3*N) {
										opponentDis=-1/3;
									}
									for(int i=0;i<board.getS();i++) {
										if(board.tiles[currentPos-3*N].getTileId()==board.supplies[i].getSupplyTileId()) {
											supplyDis=1/3;
										}
									}
								}
							}
						}
					}
					
				}
				
			}
			
			
		}
		//following the same pattern as before for the tiles located left
		else if(dice==7) {
			if(board.tiles[currentPos].getLeft()==false) {
				if(currentPos-1<N*N) {
					if(board.tiles[minotaurTile].getTileId()==currentPos-1) {
						opponentDis=-1;
					}
					for(int i=0; i<board.getS();i++) {
						if(board.tiles[currentPos-1].getTileId()==board.supplies[i].getSupplyTileId()) {
							supplyDis=1;
						}
						
					}
					if(board.tiles[currentPos-1].getLeft()==false) {
						if(currentPos-2<N*N) {
							if(board.tiles[minotaurTile].getTileId()==currentPos-2) {
								opponentDis=-1/2;
							}
							for(int i=0; i<board.getS();i++) {
								if(board.tiles[currentPos-2].getTileId()==board.supplies[i].getSupplyTileId()) {
									supplyDis=1/2;
								}
								
							}
							if(board.tiles[currentPos-2].getLeft()==false) {
								if(currentPos-3>0) {
									if(board.tiles[minotaurTile].getTileId()==currentPos-3) {
										opponentDis=-1/3;
									}
									for(int i=0;i<board.getS();i++) {
										if(board.tiles[currentPos-3].getTileId()==board.supplies[i].getSupplyTileId()) {
											supplyDis=1/3;
										}
									}
								}
							}
						}
					}
					
				}
				
			}
			
			
		}
		
		
		purpose=0.6*opponentDis+0.4*supplyDis;
		return purpose;
	}
	
	public int getNextMove(int currentPos,int minotaurTile) {
		ArrayList<Double> array= new ArrayList<Double>(200);
		Integer[] updatedPath = new Integer[5]; 
		double possibleMove=0.0,max=Double.NEGATIVE_INFINITY;
		int movement=0;
		int dice,N=board.getN();
		double temp;
		int opponentDis=0,supplyDis=0;
		
		
		
		//checking if there are walls in that tile
		//if the check is false, Theseus is able to move to that direction
		//So the number of the dice pointing to the direction that has no walls is 
		//added to the array updatedPath
		if (board.tiles[currentPos].getUp()==false) {
			array.add(1.0);
		}
		
		if(board.tiles[currentPos].getRight()==false) {
			array.add(3.0);
		}
		
		if(board.tiles[currentPos].getDown()==false) {
			array.add(5.0);
		}
		
		if(board.tiles[currentPos].getLeft()==false) {
			array.add(7.0);
		}
		//By using the function evaluate we evaluate the possible moves of Theseus
		//the best possible move has the biggest value an it is stored to the variable max
		//at the end of this for loop the best possible move is stored in the array
		for(int i=0;i<array.size();i++) {
			
			temp=array.get(i);
			dice=(int) temp;
			possibleMove=evaluate(currentPos,dice,minotaurTile);
			if(possibleMove>max) {
				
				max=possibleMove;
				movement=dice;
			}
			array.set(i,possibleMove);
		}
		//checking where theseus "chose" to move and move him 
		if(movement==1) {
			
			currentPos+=N;
			System.out.println("Theseus moves up!");
		}
		else if(movement==3) {
			
			currentPos+=1;
			System.out.println("Theseus moves right!");
		}
		else if(movement==5) {
			
			currentPos-=N;
			System.out.println("Theseus moves down!");
		}
		else if(movement==7) {
			
			currentPos-=1;
			System.out.println("Theseus moves left!");
		}
		//checking (like we did in the function evaluate) where the nearest supply or where minotaur is
		//and store those distances in the updatedPath
		if(board.tiles[currentPos].getUp()==false) {
			if(currentPos+N<N*N) {
				if(board.tiles[minotaurTile].getTileId()==currentPos+N) {
					opponentDis=1;
				}
				for(int i=0;i<board.getS();i++) {
					if(board.tiles[currentPos+N].getTileId()==board.supplies[i].getSupplyTileId()) {
						supplyDis=1;
					}
				}
				if(board.tiles[currentPos+N].getUp()==false) {
					if(currentPos+2*N<N*N) {
						if(board.tiles[minotaurTile].getTileId()==currentPos+2*N) {
							opponentDis=2;
						}
						for(int i=0;i<board.getS();i++) {
							if(board.tiles[currentPos+2*N].getTileId()==board.supplies[i].getSupplyTileId()) {
								supplyDis=2;
							}
						}
						if(board.tiles[currentPos+2*N].getUp()==false) {
							if(currentPos+3*N<N*N) {
								if(board.tiles[minotaurTile].getTileId()==currentPos+3*N) {
									opponentDis=3;
								}
								for(int i=0;i<board.getS();i++) {
									if(board.tiles[currentPos+3*N].getTileId()==board.supplies[i].getSupplyTileId()) {
										supplyDis=3;
									}
								}
							}
						}
					}
				}
			}
		}
		if(board.tiles[currentPos].getRight()==false) {
			if(currentPos+1<N*N) {
				if(board.tiles[minotaurTile].getTileId()==currentPos+1) {
					opponentDis=1;
				}
				for(int i=0;i<board.getS();i++) {
					if(board.tiles[currentPos+1].getTileId()==board.supplies[i].getSupplyTileId()) {
						supplyDis=1;
					}
				}
				if(board.tiles[currentPos+1].getRight()==false) {
					if(currentPos+2<N*N) {
						if(board.tiles[minotaurTile].getTileId()==currentPos+2) {
							opponentDis=2;
						}
						for(int i=0;i<board.getS();i++) {
							if(board.tiles[currentPos+2].getTileId()==board.supplies[i].getSupplyTileId()) {
								supplyDis=2;
							}
						}
						if(board.tiles[currentPos+2].getRight()==false) {
							if(currentPos+3<N*N) {
								if(board.tiles[minotaurTile].getTileId()==currentPos+3) {
									opponentDis=3;
								}
								for(int i=0;i<board.getS();i++) {
									if(board.tiles[currentPos+3].getTileId()==board.supplies[i].getSupplyTileId()) {
										supplyDis=3;
									}
								}
							}
						}
					}
				}
			}
		}
		if(board.tiles[currentPos].getDown()==false) {
			if(currentPos-N>0) {
				if(board.tiles[minotaurTile].getTileId()==currentPos-N) {
					opponentDis=1;
				}
				for(int i=0;i<board.getS();i++) {
					if(board.tiles[currentPos-N].getTileId()==board.supplies[i].getSupplyTileId()) {
						supplyDis=1;
					}
				}
				if(board.tiles[currentPos-N].getDown()==false) {
					if(currentPos-2*N>0) {
						if(board.tiles[minotaurTile].getTileId()==currentPos-2*N) {
							opponentDis=2;
						}
						for(int i=0;i<board.getS();i++) {
							if(board.tiles[currentPos-2*N].getTileId()==board.supplies[i].getSupplyTileId()) {
								supplyDis=2;
							}
						}
						if(board.tiles[currentPos-2*N].getLeft()==false) {
							if(currentPos-3*N>0) {
								if(board.tiles[minotaurTile].getTileId()==currentPos-3*N) {
									opponentDis=3;
								}
								for(int i=0;i<board.getS();i++) {
									if(board.tiles[currentPos-3*N].getTileId()==board.supplies[i].getSupplyTileId()) {
										supplyDis=3;
									}
								}
							}
						}
					}
				}
			}
		}
		if(board.tiles[currentPos].getLeft()==false) {
			if(currentPos-1>0) {
				if(board.tiles[minotaurTile].getTileId()==currentPos-1) {
					opponentDis=1;
				}
				for(int i=0;i<board.getS();i++) {
					if(board.tiles[currentPos-1].getTileId()==board.supplies[i].getSupplyTileId()) {
						supplyDis=1;
					}
				}
				if(board.tiles[currentPos-1].getLeft()==false) {
					if(currentPos-2>0) {
						if(board.tiles[minotaurTile].getTileId()==currentPos-2) {
							opponentDis=2;
						}
						for(int i=0;i<board.getS();i++) {
							if(board.tiles[currentPos-2].getTileId()==board.supplies[i].getSupplyTileId()) {
								supplyDis=2;
							}
						}
						if(board.tiles[currentPos-2].getLeft()==false) {
							if(currentPos-3>0) {
								if(board.tiles[minotaurTile].getTileId()==currentPos-3) {
									opponentDis=3;
								}
								for(int i=0;i<board.getS();i++) {
									if(board.tiles[currentPos-3].getTileId()==board.supplies[i].getSupplyTileId()) {
										supplyDis=3;
									}
								}
							}
						}
					}
				}
			}
		}
		
		
		for(int i=0; i<board.getS();i++) {
			if(board.tiles[currentPos].getTileId()==board.supplies[i].getSupplyTileId()) {
				setScore(getScore()+1);
				board.supplies[i].supplyTileId=0;
    	    	board.supplies[i].x=0;
    	    	board.supplies[i].y=0;
			}
		}
		
		updatedPath[0]=movement;
		updatedPath[1]=getScore();
		updatedPath[2]=opponentDis;
		updatedPath[3]=supplyDis;
		
		path.add(updatedPath);
		
		return currentPos;
		
		
	}
	
	public void statistics(int minotaurId, int gameRound) {
		Integer[] round = new Integer [4];
		float moveUp=0,moveDown=0,moveRight=0,moveLeft=0,move=0;
		int N=board.getN();
		
		
		round[0]=1;
		round[1]=getScore();
		round[2]=0;
		round[3]=0;
		path.set(0, round);
		
		
		
				
		path.get(path.size()-1);
		
		
		
		System.out.println("Theseus collected " + getScore()+" supplies");
		
		System.out.print("The smallest supply distance is: ");
		
		System.out.println(path.get(path.size()-1)[3]);
		
		System.out.println("The minotaur distance is: " +path.get(path.size()-1)[2]);
		                                                                                
		                                                                                
		//checking if the round is ending 
		if(minotaurId==N*getX()+getY() || gameRound==200 || getScore()==4) {
			
			for(int i=0;i<path.size();i++) {
				round=path.get(i);
				if(round[0]==1) {
					moveUp++;
				}
				else if(round[0]==3) {
					moveRight++;
				}
				else if(round[0]==5) {
					moveDown++;
				}
				else if(round[0]==7) {
					moveLeft++;
				}
				move++;
			}
			System.out.println("Theseus moved up: "+ moveUp/move*100+ "% of the times");
			
			System.out.println("Theseus moved right: "+ moveRight/move*100+ "% of the times");
			
			System.out.println("Theseus moved down: "+ moveDown/move*100+ "% of the times");
			
			System.out.println("Theseus moved left: "+ moveLeft/move*100+ "% of the times");
		}
		
		
	}

}
