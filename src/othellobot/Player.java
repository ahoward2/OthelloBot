package othellobot;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 
 * The Player class represents a player in the Othello game. Heuristics will be used
 * in the methods to analyze the board and calculate next moves.
 * 
 * @author Austin Howard
 * @version 1.0
 * @since 2019-08-29
 *
 */
public class Player {
	/*
	 * The colors of the pieces will be represented as
	 * Black = 1
	 * White = -1
	 * Empty = 0
	 */
	
	String color; //to be represented as above integer values
	int colorInt;
	
	
	
	Player(){
		
	}
	
	public void receiveInput(String input) {
		if (input == "I B") {
			this.color = "BLACK";
			this.colorInt = 1;
		}
		
		if (input == "I W") {
			this.color = "WHITE";
			this.colorInt = -1;
		}
	}

	public String sendMove(String move) {
		//System.out.println(color + " player sending move: " + move);
		return move;
	}
	
	public ArrayList <Integer> findPossibleMoves(Board board, Player player) { //change this to return the list of moves
		//System.out.println("PLAYER findPossibleMoves method for --- " + player.color);
		int oppPlayerInt = player.getColorInt()*-1;
		int[][] currentBoard = board.getBoardArray();
		ArrayList<Integer> moveList = new ArrayList<Integer>();
		boolean validSpace;
		
		//make a for loop that goes through the board and make a list of all possible moves in the format (a 3)
		//so that moves can be compatible with the format of moves
		
		
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				validSpace = false;
				//logic for checking to see if the move is valid
				if (currentBoard[i][j] == 0) { //if space is empty
					validSpace = true;
				}
				if (currentBoard[i][j] == 2) {
					validSpace = false;
				}
				if (currentBoard[i-1][j-1] == (player.getColorInt()*-1) && validSpace == true) {
					//System.out.println("checking NW direction for - " + i + j);
					//check for "me" piece in the same line
					int nextI = (i-1);
					int nextJ = (j-1);
					while (currentBoard[nextI][nextJ] == oppPlayerInt) {
						nextI -= 1;
						nextJ -= 1;
						if (currentBoard[nextI][nextJ] == player.getColorInt()) {
							//System.out.println("adding move - " + i + j);
							moveList.add(i);
							moveList.add(j);
							validSpace = false; //no longer a valid space once added to move list
						}
					}
				}
				if (currentBoard[i][j-1] == (player.getColorInt()*-1) && validSpace == true){
					//System.out.println("checking N direction for - " + i + j);
					//check for "me" piece in the same line
					int nextI = i;
					int nextJ = (j-1);
					while (currentBoard[nextI][nextJ] == oppPlayerInt) {
						nextI -= 0;
						nextJ -= 1;
						if (currentBoard[nextI][nextJ] == player.getColorInt()) {
							//System.out.println("adding move - " + i + j);
							moveList.add(i);
							moveList.add(j);
							validSpace = false; //no longer a valid space once added to move list
						}
					}
				}
				if (currentBoard[i+1][j-1] == (player.getColorInt()*-1) && validSpace == true) {
					//System.out.println("checking NE direction for - " + i + j);
					//check for "me" piece in the same line
					int nextI = (i+1);
					int nextJ = (j-1);
					while (currentBoard[nextI][nextJ] == oppPlayerInt) {
						nextI += 1;
						nextJ -= 1;
						if (currentBoard[nextI][nextJ] == player.getColorInt()) {
							//System.out.println("adding move - " + i + j);
							moveList.add(i);
							moveList.add(j);
							validSpace = false; //no longer a valid space once added to move list
						}
					}
				}
				if (currentBoard[i-1][j] == (player.getColorInt()*-1) && validSpace == true) {
					//System.out.println("checking W direction for - " + i + j);
					//check for "me" piece in the same line
					int nextI = (i-1);
					int nextJ = j;
					while (currentBoard[nextI][nextJ] == oppPlayerInt) {
						nextI -= 1;
						nextJ -= 0;
						if (currentBoard[nextI][nextJ] == player.getColorInt()) {
							//System.out.println("adding move - " + i + j);
							moveList.add(i);
							moveList.add(j);
							validSpace = false; //no longer a valid space once added to move list
						}
					}
				}
				if (currentBoard[i+1][j] == (player.getColorInt()*-1) && validSpace == true) {
					//System.out.println("checking E direction for - " + i + j);
					//check for "me" piece in the same line
					int nextI = (i+1);
					int nextJ = j;
					while (currentBoard[nextI][nextJ] == oppPlayerInt) {
						nextI += 1;
						nextJ -= 0;
						if (currentBoard[nextI][nextJ] == player.getColorInt()) {
							//System.out.println("adding move - " + i + j);
							moveList.add(i);
							moveList.add(j);
							validSpace = false; //no longer a valid space once added to move list
						}
					}
				}
				if (currentBoard[i-1][j+1] == (player.getColorInt()*-1) && validSpace == true) {
					//System.out.println("checking SW direction for - " + i + j);
					//check for "me" piece in the same line
					int nextI = (i-1);
					int nextJ = (j+1);
					while (currentBoard[nextI][nextJ] == oppPlayerInt) {
						nextI -= 1;
						nextJ += 1;
						if (currentBoard[nextI][nextJ] == player.getColorInt()) {
							//System.out.println("adding move - " + i + j);
							moveList.add(i);
							moveList.add(j);
							validSpace = false; //no longer a valid space once added to move list
						}
					}
				}
				if (currentBoard[i][j+1] == (player.getColorInt()*-1) && validSpace == true) {
					//System.out.println("checking S direction for - " + i + j);
					//check for "me" piece in the same line
					int nextI = i;
					int nextJ = (j+1);
					while (currentBoard[nextI][nextJ] == oppPlayerInt) {
						nextI -= 0;
						nextJ += 1;
						if (currentBoard[nextI][nextJ] == player.getColorInt()) {
							//System.out.println("adding move - " + i + j);
							moveList.add(i);
							moveList.add(j);
							validSpace = false; //no longer a valid space once added to move list
						}
					}
				}
				if (currentBoard[i+1][j+1] == (player.getColorInt()*-1) && validSpace == true) {
					//System.out.println("checking SE direction for - " + i + j);
					//check for "me" piece in the same line
					int nextI = (i+1);
					int nextJ = (j+1);
					while (currentBoard[nextI][nextJ] == oppPlayerInt) {
						nextI += 1;
						nextJ += 1;
						if (currentBoard[nextI][nextJ] == player.getColorInt()) {
							//System.out.println("adding move - " + i + j);
							moveList.add(i);
							moveList.add(j);
							validSpace = false; //no longer a valid space once added to move list
						}
					}
				}
			}
		}
		return moveList;
		
	}
	
	public int[] chooseMove(ArrayList<Integer> moveList) {
		//System.out.println("PLAYER chooseMove method for --- "+this.color);
		int counter = 0;
		int[] move = new int[2];
		for(Integer i: moveList) {
			if (counter < 2) {
				move[counter] = i;
				counter++;
			}
		}
		//for (int j: move) {
			//System.out.println(j);
		//}
		return move;
	}
	
	public String formatMove(int[] move, Player player) {
		String formattedMove = "";
		String column = "";
		String row = " " + String.valueOf(move[1]);
		boolean pass = false;
		
		if (move[0] == 0 && move[1] == 0) {
			//no available moves so we need to send a pass: either "B" or "W"
			pass = true;
		}
		
		if (player.getColorInt() == 1) {
			//player is BLACK
			formattedMove += "B";
		}
		else {
			//player is WHITE
			formattedMove += "W";
		}
		
		if (pass == false) {
			if (move[0] == 1) {
				column += "a";
			}
			else if (move[0] == 2) {
				column += "b";
			}
			else if (move[0] == 3) {
				column += "c";
			}
			else if (move[0] == 4) {
				column += "d";
			}
			else if (move[0] == 5) {
				column += "e";
			}
			else if (move[0] == 6) {
				column += "f";
			}
			else if (move[0] == 7) {
				column += "g";
			}
			else if (move[0] == 8) {
				column += "h";
			}
			
			//add column and row
			formattedMove += " " + column; //add column letter to formatted string
			formattedMove += row;
		}
		
		return formattedMove;
	}
	
	public int getColorInt() {
		return colorInt;
	}

	public void setColorInt(int colorInt) {
		this.colorInt = colorInt;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
