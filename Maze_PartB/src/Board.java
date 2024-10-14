import java.util.Random;

public class Board {
	int N;
	int S;
	int W;
	Tile[] tiles;
	Supply[] supplies;
	
	public Board() {
	        N = 0;
	        S = 0;
	        W = 0;
	        
	    }

	 public Board(int N, int S, int W) {
	        this.N = N;
	        this.S = S;
	        this.W = W;
	        tiles = new Tile[N*N];
	        supplies = new Supply[S];
	    }

	 public Board(Board board){
	        board.N = N;
	        board.S = S;
	        board.W = W;
	        board.tiles = tiles;
	        board.supplies = supplies;
	    }

	    public int getN() {
	        return N;
	    }

	    public void setN(int N) {
	        this.N = N;
	    }

	    public int getS() {
	        return S;
	    }

	    public void setS(int S) {
	        this.S = S;
	    }

	    public int getW() {
	        return W;
	    }

	    public void setW(int W) {
	    	this.W=W;
	    }

	    void createTile() {
	        tiles = new Tile[N*N];
	        Random r=new Random();
	        int rand;
	        int count;
	        //initialization of the corner tiles
	        tiles[0]=new Tile(0,0,0,false,true,false,true);
	        tiles[N-1]=new Tile(N-1,0,N-1,false,true,true,false);
	        tiles[N*(N-1)]=new Tile(N*(N-1),N-1,0,true,false,false,true);
	        tiles[N*N-1]=new Tile(N*N-1,N-1,N-1,true,false,true,false);
	        	for(int i = 0; i<N; i++) {
	        		for(int j=0;j<N;j++) {
	        			
	        		
	        		//initialization of the frame
	        		if(j!=0 && j!=N-1 && j!=N*(N-1) && j!=N*N-1) {
	        			tiles[j]=new Tile(j,0,j,false,true,false,false);
	        			tiles[N*j]=new Tile(N*j,j,0,false,false,false,true);
	        			tiles[N*j+N-1]=new Tile((N-1)*j+N-1,j,N-1,false,false,true,false);
	        			tiles[j+N*N-N]=new Tile(N*(N-1)+j,N-1,j,true,false,false,false);
	        			
	        		}
	        		//initialization of the rest of the tiles
	        		if(tiles[N*i+j]==null) {
	        			tiles[N*i+j]= new Tile(N*i+j,i,j,false,false,false,false);
	        					
		    	        		
		    	        		}
	        		}
	        }
	        	
	        	
	        	//putting the walls 
	        	//4*N is the number of the walls put int the frame
	        	for(int i=0;i<W-4*N;i++) {
	        		rand=r.nextInt(N*N);
	        		int temp=r.nextInt(4);
	        		count=0;
	        		int count1=0;
	        		
	        		if(tiles[rand].getUp()==true) {
	        			count++;
	        		}
	        		if(tiles[rand].getDown()==true) {
	        			count++;
	        		}
	        		if(tiles[rand].getRight()==true) {
	        			count++;
	        		}
	        		if(tiles[rand].getLeft()==true) {
	        			count++;
	        		}
	        		
	        		if(count==0 || count==1) {
	        			if(temp==0) {
	        				if(tiles[rand].getUp()==true) {
		        				continue;
		        			}
		        			else {
		        				//checking if the neighbor tile is within the bounds of the tiles array
		        				if(rand+N<N*N) {
		        					count1=0;
		        					if(tiles[rand+N].getUp()==true)
		        						count1++;
		        					if(tiles[rand+N].getLeft()==true)
		        						count1++;
		        					if(tiles[rand+N].getRight()==true)
		        						count1++;
		        					if(count1<2) {
		        						tiles[rand+N].setDown(true);
		        						tiles[rand].setUp(true);
		        						i++;
		        						continue;
		        					}
		        				}
		        			}
	        			}
	        			else if(temp==1) {
	        				if(tiles[rand].getLeft()==true)
		        				continue;
		        			else {
		        				if(rand-1>0) {
		        					count1=0;
		        					if(tiles[rand-1].getUp()==true)
		        						count1++;
		        					if(tiles[rand-1].getDown()==true)
		        						count1++;
		        					if(tiles[rand-1].getLeft()==true)
		        						count1++;
		        					if(count1<2) {
		        						tiles[rand-1].setRight(true);
		        						tiles[rand].setLeft(true);
		        						i++;
		        						continue;
		        					}
	        				
		        				}
	        			
	        				}
	        			}
	        			else if(temp==2) {
	        				if(tiles[rand].getRight()==true)
	        					continue;
	        				else {
	        					if(rand+1<N*N) {
	        						count1=0;
	        						if(tiles[rand+1].getUp()==true)
		        						count1++;
		        					if(tiles[rand+1].getDown()==true)
		        						count1++;
		        					if(tiles[rand+1].getRight()==true)
		        						count1++;
		        					if(count1<2) {
		        						tiles[rand+1].setLeft(true);
		        						tiles[rand].setRight(true);
		        						i++;
		        						continue;
		        					}
	        					}
	        					
	        				}
	        			}
	        			
	        			else if(temp==3) {
	        				if(tiles[rand].getDown()==true) {
	        					continue;
	        				}
	        				else {
	        					if(rand-N>0) {
	        						count1=0;
	        						if(tiles[rand-N].getLeft()==true)
		        						count1++;
		        					if(tiles[rand-N].getDown()==true)
		        						count1++;
		        					if(tiles[rand-N].getRight()==true)
		        						count1++;
		        					if(count1<2) {
		        						tiles[rand-N].setUp(true);
		        						tiles[rand].setDown(true);
		        						i++;
		        						continue;
		        					}
		        					
	        					}
	        				}
	        			}
	        				
	        		}
	        		else
	        			continue;
	        	}
	        			
	        	
	        	
	        
	      
	      }

	    void createSupply() {
	    	
	        Random r = new Random();
	        supplies = new Supply[S];
	        int a,b,c;
	        for(int j = 0; j<S; j++) {
	        	b=r.nextInt(N-1)+1;//random supplytileid.x
	        	c=r.nextInt(N-1)+1;//random supplytileid.y
	        	a=N*b+c;
	        	//initialization of the supplies
	        	supplies[j] = new Supply(j,b,c,a);
	        	//checking if the tile is occupied by an another supply
	        	for(int i=1;i<j;i++) {
	        		if(supplies[j].supplyTileId!=supplies[i].supplyTileId) {
	        			supplies[j] = new Supply(j,b,c,a);
	        		}	
	        			else 
	        				j--;
	            
	        	}
	        	
	        }
	       
	   }

	    void createBoard() {
	        createTile();
	        createSupply();
	       
	    }
	        
	    
	    String[][] getStringRepresentation(int theseusTile, int minotaurTile){
	    	String [][] arr = new String [2*N+1][N];
	    	
	    	
	    	//in the first column of the printed array we have 5 spaces example +---+ in the other 
	    	//columns there are 4 spaces
	    	//that rule applies to the representation of the board the players and the supplies
	    	for(int i=0;i<N*N;i++) {
	    		if(tiles[i].up==true) {
	    				if(tiles[i].y==0) {
	    					arr[2*tiles[i].x+2][tiles[i].y]="+---+";
	    				}
	    				else {
	    					arr[2*tiles[i].x+2][tiles[i].y]="---+";
	    				}
	    		}
	    		else {
	    				if(tiles[i].y==0) {
	    					arr[2*tiles[i].x+2][tiles[i].y]="+   +";
	    				}
	    				else
	    					arr[2*tiles[i].x+2][tiles[i].y]="   +";
	    			
	    		}
	    		
	    			
	    		if(tiles[i].down==true) {
	    			
	    				if(tiles[i].y==0) {
	    					arr[2*tiles[i].x][tiles[i].y]="+---+";
	    				}
	    				else
	    					arr[2*tiles[i].x][tiles[i].y]="---+";
	    			}
	    		else {
	    				if(tiles[i].y==0) {
	    					arr[2*tiles[i].x][tiles[i].y]="+   +";
	    				}
	    				else
	    					arr[2*tiles[i].x][tiles[i].y]="   +";
	    		}
	    			
	    		if(tiles[i].right==true) {
	    				if(tiles[i].y==0) {
	    					arr[2*tiles[i].x+1][tiles[i].y]="    |";
	    				}
	    				else {
	    					arr[2*tiles[i].x+1][tiles[i].y]="   |";
	    				}
	    		}
	    		else {
	    			if(tiles[i].y==0) {
    					arr[2*tiles[i].x+1][tiles[i].y]="     ";
    				}
    				else {
    					arr[2*tiles[i].x+1][tiles[i].y]="    ";
    				}
	    		}
	    		if(tiles[i].left==true) {
	    			
	    				if(tiles[i].y==0) {
	    					arr[2*tiles[i].x+1][tiles[i].y]="|    ";
	    				}
	    		}
	    			
	    	}
	    	
	    	
	    	for(int j=0;j<S;j++) {
				if(tiles[supplies[j].supplyTileId].left==true) {
					if(tiles[supplies[j].supplyTileId].right==true) {
							if(tiles[supplies[j].supplyTileId].y==0)
								arr[2*tiles[supplies[j].supplyTileId].x+1][tiles[supplies[j].supplyTileId].y]="| s"+(j+1)+"|";
							else
								arr[2*tiles[supplies[j].supplyTileId].x+1][tiles[supplies[j].supplyTileId].y]=" s"+(j+1)+"|";
						}	
					else {
						if(tiles[supplies[j].supplyTileId].y==0)
							arr[2*tiles[supplies[j].supplyTileId].x+1][tiles[supplies[j].supplyTileId].y]="| s"+(j+1)+" ";
						else
							arr[2*tiles[supplies[j].supplyTileId].x+1][tiles[supplies[j].supplyTileId].y]=" s"+(j+1)+" ";
						}
					}
				else {
					if(tiles[supplies[j].supplyTileId].right==true) {
							if(tiles[supplies[j].supplyTileId].y==0)
								arr[2*tiles[supplies[j].supplyTileId].x+1][tiles[supplies[j].supplyTileId].y]=" s"+(j+1)+" |";
							else
								arr[2*tiles[supplies[j].supplyTileId].x+1][tiles[supplies[j].supplyTileId].y]=" s"+(j+1)+"|";
						}
					else {
							if(tiles[supplies[j].supplyTileId].y==0)
								arr[2*tiles[supplies[j].supplyTileId].x+1][tiles[supplies[j].supplyTileId].y]=" s"+(j+1)+"  ";
							else
								arr[2*tiles[supplies[j].supplyTileId].x+1][tiles[supplies[j].supplyTileId].y]=" s"+(j+1)+" ";
						}	
					}
					
				}
	    	
	   
	    	
	    		if(tiles[theseusTile].left==true) {
					if(tiles[theseusTile].right==true) {
							if(tiles[theseusTile].y==0)
								arr[2*tiles[theseusTile].x+1][tiles[theseusTile].y]="| T |";
							else
								arr[2*tiles[theseusTile].x+1][tiles[theseusTile].y]=" T |";
								
					}
					else {
							if(tiles[theseusTile].y==0)
								arr[2*tiles[theseusTile].x+1][tiles[theseusTile].y]="| T  ";
							else
								arr[2*tiles[theseusTile].x+1][tiles[theseusTile].y]=" T  ";
						}
	    		}
					
				
				else {
					if(tiles[theseusTile].right==true) {
							if(tiles[theseusTile].y==0)
								arr[2*tiles[theseusTile].x+1][tiles[theseusTile].y]="  T |";
							else
								arr[2*tiles[theseusTile].x+1][tiles[theseusTile].y]=" T |";
						}
					
					else {
						
							if(tiles[theseusTile].y==0)
								arr[2*tiles[theseusTile].x+1][tiles[theseusTile].y]="  T  ";
							else
								arr[2*tiles[theseusTile].x+1][tiles[theseusTile].y]=" T  ";
						}
						
							
					}
	    		
						
					
				
	    		if(tiles[minotaurTile].left==true) {
					if(tiles[minotaurTile].right==true) {
							if(tiles[minotaurTile].y==0)
								arr[2*tiles[minotaurTile].x+1][tiles[minotaurTile].y]="| M |";
							else
								arr[2*tiles[minotaurTile].x+1][tiles[minotaurTile].y]="  M|";
								
						}					
					
					else {
							if(tiles[minotaurTile].y==0)
								arr[2*tiles[minotaurTile].x+1][tiles[minotaurTile].y]="| M  ";
							else
								arr[2*tiles[minotaurTile].x+1][tiles[minotaurTile].y]=" M  ";
								
						}	
					}
						
				
				else {
					if(tiles[minotaurTile].right==true) {
						
							if(tiles[minotaurTile].y==0)
								arr[2*tiles[minotaurTile].x+1][tiles[minotaurTile].y]="  M |";
							else
								arr[2*tiles[minotaurTile].x+1][tiles[minotaurTile].y]=" M |";
						}	
					
					else {
							if(tiles[minotaurTile].y==0)
								arr[2*tiles[minotaurTile].x+1][tiles[minotaurTile].y]="  M  ";
							else
								arr[2*tiles[minotaurTile].x+1][tiles[minotaurTile].y]=" M  ";
						}
						
							
					}
	    		//swapping the rows (the first row with the last, the second row with the second-last etc.)
	    		//so that the counting of the tiles begins from the bottom row
	    		for(int i=0;i<(2*N+1)/2;i++) {
	    			for(int j=0;j<N;j++) {
	    				String temp;
	    				temp=arr[i][j];
	    				arr[i][j]=arr[2*N-i][j];
	    				arr[2*N-i][j]=temp;
	    			}
	    		}
	    	
				
				
	    	for(int i=0;i<2*N+1;i++) {
	    		for(int j=0;j<N;j++) {
	    			System.out.print(arr[i][j]);
	    		}
	    		System.out.println();
	    	}
    		
	    	return arr;
	    	
	    }

	   }
