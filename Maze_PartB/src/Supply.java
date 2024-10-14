
public class Supply {	

	    int supplyId;
	    int x;
	    int y;
	    int supplyTileId;
	    

	    public Supply(){
	        supplyId = 0;
	        x = 0;
	        y = 0;
	        supplyTileId = 0;
	        
	    }

	    public Supply(int supplyId, int x, int y, int sypplyTileId){
	        this.supplyId = supplyId;
	        this.x = x;
	        this.y = y;
	        this.supplyTileId = sypplyTileId; 

	    }
	    
	   

	    public int getSupplyId() {
	        return supplyId;
	    }

	    public void setSupplyId(int supplyId) {
	        this.supplyId = supplyId;
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

	    public int getSupplyTileId() {
	        return supplyTileId;
	    }

	    public void setSupplyTileId(int supplyTileId) {
	        this.supplyTileId = supplyTileId;
	    }

	
}
