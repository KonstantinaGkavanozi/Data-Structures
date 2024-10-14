
public class Tile {
	
		int tileId;
		int x;
		int y;
		boolean up;
		boolean down;
		boolean left;
		boolean right;
		
		public Tile(){
			tileId=0;
			x=0;
			y=0;
			up = false;
			down = false;
			left = false;
			right = false;
		}
		
		public Tile(int tileId, int x, int y, boolean up, boolean down, boolean right, boolean left){
	        this.tileId = tileId;
	        this.x = x;
	        this.y = y;
	        this.up = up;
	        this.down = down;
	        this.right = right;
	        this.left = left;
	    }
		
		public int getTileId() {
			return tileId;
		}
		
		public void setTileId(int tileId) {
			this.tileId = tileId;
		}
		
		public int getX() {
			return x;
		}
		
		public void setX(int x) {
			this.x=x;
		}
		
		public int getY() {
			return y;
			
		}
		
		public void setY(int y) {
			this.y=y;
		}
		
		public boolean getUp() {
			return up;
		}
		
		public void setUp(boolean up) {
			this.up=up;
		}
		
		public boolean getDown() {
			return down;
		}
		
		public void setDown(boolean down) {
			this.down=down;
		}
		
		public boolean getLeft() {
			return left;
		}
		
		public void setLeft(boolean left) {
			this.left=left;
		}
		
		public boolean getRight() {
			return right;
		}
		
		public void setRight(boolean right) {
			this.right=right;
		}
		
	}

