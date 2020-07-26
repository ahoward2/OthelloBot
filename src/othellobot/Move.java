package othellobot;

import java.util.ArrayList;

public class Move {
	
	private int weight;
	private String moveString;
	private int[] moveIndex;
	
	Move(String moveString, int[] moveIndex){
		this.weight = 0; //default for testing
		this.moveString = moveString;
		this.moveIndex = moveIndex;
	}
	
	public void sumCapturableDiscs(Board board, Player player) {
		int[][] currentBoard = board.getBoardArray();
		int oppPlayerInt = player.getColorInt()*-1;
		ArrayList<Integer> finalFlipList = new ArrayList<Integer>();
		ArrayList<Integer> tempFlipList = new ArrayList<Integer>();
		
		if (currentBoard[moveIndex[0]-1][moveIndex[1]-1] == (player.getColorInt()*-1)) {
			//System.out.println("Check NW direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (moveIndex[0]-1);
			int nextJ = (moveIndex[1]-1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 1;
				nextJ -= 1;
				if (currentBoard[nextI][nextJ] == player.getColorInt()) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[moveIndex[0]][moveIndex[1]-1] == (player.getColorInt()*-1)) {
			//System.out.println("Check N direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = moveIndex[0];
			int nextJ = (moveIndex[1]-1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 0;
				nextJ -= 1;
				if (currentBoard[nextI][nextJ] == player.getColorInt()) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[moveIndex[0]+1][moveIndex[1]-1] == (player.getColorInt()*-1)) {
			//System.out.println("Check NE direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (moveIndex[0]+1);
			int nextJ = (moveIndex[1]-1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI += 1;
				nextJ -= 1;
				if (currentBoard[nextI][nextJ] == player.getColorInt()) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[moveIndex[0]-1][moveIndex[1]] == (player.getColorInt()*-1)) {
			//System.out.println("Check W direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (moveIndex[0]-1);
			int nextJ = moveIndex[1];
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 1;
				nextJ -= 0;
				if (currentBoard[nextI][nextJ] == player.getColorInt()) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[moveIndex[0]+1][moveIndex[1]] == (player.getColorInt()*-1)) {
			//System.out.println("Check E direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (moveIndex[0]+1);
			int nextJ = moveIndex[1];
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI += 1;
				nextJ -= 0;
				if (currentBoard[nextI][nextJ] == player.getColorInt()) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[moveIndex[0]-1][moveIndex[1]+1] == (player.getColorInt()*-1)) {
			//System.out.println("Check SW direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (moveIndex[0]-1);
			int nextJ = (moveIndex[1]+1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 1;
				nextJ += 1;
				if (currentBoard[nextI][nextJ] == player.getColorInt()) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[moveIndex[0]][moveIndex[1]+1] == (player.getColorInt()*-1)) {
			//System.out.println("Check S direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = moveIndex[0];
			int nextJ = (moveIndex[1]+1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 0;
				nextJ += 1;
				if (currentBoard[nextI][nextJ] == player.getColorInt()) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[moveIndex[0]+1][moveIndex[1]+1] == (player.getColorInt()*-1)) {
			//System.out.println("Check SE direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (moveIndex[0]+1);
			int nextJ = (moveIndex[1]+1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI += 1;
				nextJ += 1;
				if (currentBoard[nextI][nextJ] == player.getColorInt()) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		this.weight = finalFlipList.size();
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
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
