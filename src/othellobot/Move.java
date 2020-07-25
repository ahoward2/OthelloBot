package othellobot;

public class Move {
	
	private double weight;
	private String moveString;
	private int[] moveIndex;
	
	Move(String moveString, int[] moveIndex){
		this.weight = 0; //default for testing
		this.moveString = moveString;
		this.moveIndex = moveIndex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getMoveString() {
		return moveString;
	}

	public void setMoveString(String moveString) {
		this.moveString = moveString;
	}

	public int[] getMoveIndex() {
		return moveIndex;
	}

	public void setMoveIndex(int[] moveIndex) {
		this.moveIndex = moveIndex;
	}
	
	
	
	

}
