package othellobot;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The board class represents the Othello game board and all of it's functions
 * that players can interact with.
 * 
 * @author Austin Howard
 * @version 1.0
 * @since 2019-08-29
 */
public class Board {
	
	/*
	 * The colors of the pieces will be represented as
	 * Black = 1
	 * White = -1
	 * Empty = 0
	 */
	
	static int[][] boardArray = new int[10][10];
	
	Board() {
		//initialize top border of the board to 2's
		for (int i = 0; i < 10; i++) {
			boardArray[i][0] = 2;
		}
		//initialize left border of the board to 2's
		for (int i = 0; i < 10; i++) {
			boardArray[0][i] = 2;
		}
		//initialize right border of the board to 2's
		for (int i = 0; i < 10; i++) {
			boardArray[9][i] = 2;
		}
		//initialize bottom border of the board to 2's
		for (int i = 0; i < 10; i++) {
			boardArray[i][9] = 2;
		}
		//initialize the 4 middle pieces
		boardArray[4][4] = -1;
		boardArray[4][5] = 1;
		boardArray[5][4] = 1;
		boardArray[5][5] = -1;
		
	}
	
	/**
	 * 
	 * @param move String that indicates color, column, row in format (EX, (B) a 2)
	 */
	public void receiveMove(String move) {
		String color; //identify color of piece from String input (Ex, (B) a 1)
		String column;
		String row;
		boolean pass = false;
		
		if (move.compareTo("B") == 0 || move.compareTo("W") == 0) {
			// a pass has been made by either white or black
			pass = true;
		}
		
		if (pass == false) {
			color = move.substring(0, 1);
			column = move.substring(2,3);
			row = move.substring(4);
			
			int colNumber = 0; //column letter must be converted to integer to use the boardArrayfor a move
			
			if (column.compareTo("a") == 0 ) {
				colNumber = 1;
			}
			
			else if (column.compareTo("b") == 0) {
				colNumber = 2;
			}
			
			else if (column.compareTo("c") == 0) {
				colNumber = 3;
			}
			
			else if (column.compareTo("d") == 0) {
				colNumber = 4;
			}
			
			else if (column.compareTo("e") == 0) {
				colNumber = 5;
			}
			
			else if (column.compareTo("f") == 0) {
				colNumber = 6;
			}
			
			else if (column.compareTo("g") == 0) {
				colNumber = 7;
			}
			
			else if (column.compareTo("h") == 0) {
				colNumber = 8;
			}
			
			//System.out.println("BOARD receiveMove method --- color=" + color + ", col=" + column + ", row=" + row);
			
			//check to see which int value to insert depending on which color made the move
			if (color.compareTo("B") == 0) {
				boardArray[colNumber][Integer.valueOf(row)] = 1;
				//System.out.println("Move executed for BLACK");
				this.updateBoard(1, colNumber, Integer.valueOf(row));
			}
			else if (color.compareTo("W") == 0) {
				boardArray[colNumber][Integer.valueOf(row)] = -1;
				//System.out.println("Move executed for WHITE");
				this.updateBoard(-1, colNumber, Integer.valueOf(row));
			}
		}
		
		
	}
	
	
	public void updateBoard(int playerColorInt, int column, int row) {
		//System.out.println("BOARD updateBoard method for --- " + "ColorInt: " + playerColorInt + ", " + "Column: " + column + ", " + "Row: " + row);
		int[][] currentBoard = this.getBoardArray();
		int oppPlayerInt = playerColorInt*-1;
		ArrayList<Integer> finalFlipList = new ArrayList<Integer>();
		ArrayList<Integer> tempFlipList = new ArrayList<Integer>();
		
		if (currentBoard[column-1][row-1] == (playerColorInt*-1)) {
			//System.out.println("Check NW direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (column-1);
			int nextJ = (row-1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 1;
				nextJ -= 1;
				if (currentBoard[nextI][nextJ] == playerColorInt) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[column][row-1] == (playerColorInt*-1)) {
			//System.out.println("Check N direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = column;
			int nextJ = (row-1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 0;
				nextJ -= 1;
				if (currentBoard[nextI][nextJ] == playerColorInt) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[column+1][row-1] == (playerColorInt*-1)) {
			//System.out.println("Check NE direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (column+1);
			int nextJ = (row-1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI += 1;
				nextJ -= 1;
				if (currentBoard[nextI][nextJ] == playerColorInt) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[column-1][row] == (playerColorInt*-1)) {
			//System.out.println("Check W direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (column-1);
			int nextJ = row;
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 1;
				nextJ -= 0;
				if (currentBoard[nextI][nextJ] == playerColorInt) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[column+1][row] == (playerColorInt*-1)) {
			//System.out.println("Check E direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (column+1);
			int nextJ = row;
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI += 1;
				nextJ -= 0;
				if (currentBoard[nextI][nextJ] == playerColorInt) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[column-1][row+1] == (playerColorInt*-1)) {
			//System.out.println("Check SW direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (column-1);
			int nextJ = (row+1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 1;
				nextJ += 1;
				if (currentBoard[nextI][nextJ] == playerColorInt) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[column][row+1] == (playerColorInt*-1)) {
			//System.out.println("Check S direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = column;
			int nextJ = (row+1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI -= 0;
				nextJ += 1;
				if (currentBoard[nextI][nextJ] == playerColorInt) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		
		if (currentBoard[column+1][row+1] == (playerColorInt*-1)) {
			//System.out.println("Check SE direction for pieces to flip");
			//check for "me" piece in the same line
			int nextI = (column+1);
			int nextJ = (row+1);
			while (currentBoard[nextI][nextJ] == oppPlayerInt) {
				tempFlipList.add(nextI);
				tempFlipList.add(nextJ);
				nextI += 1;
				nextJ += 1;
				if (currentBoard[nextI][nextJ] == playerColorInt) {
					//If move does flank opponent pieces, add to finalFlipList
					for (int item: tempFlipList) {
						finalFlipList.add(item);
					}
				}
			}
			tempFlipList.clear(); //clear the temporary list to continue evaluating directions
		}
		//print finalFlipList for testing
		//System.out.println("Pieces that need to be flipped");
		//for (int item: finalFlipList) {
			//System.out.print(item + ",");
		//}
		//System.out.println();
		
		int flipListCounter = 0;
		int columnToFlip = 0;
		int rowToFlip = 0;
		for (int item: finalFlipList) {
			
			if (flipListCounter == 0) {
				columnToFlip = item;
				flipListCounter ++;
			}
			else if (flipListCounter == 1) {
				rowToFlip = item;
				flipListCounter = 0;
				currentBoard[columnToFlip][rowToFlip] = playerColorInt;
			}
		}
		
		
	}
	
	public String formatMove(int[] move, int playerColorInt) {
		String formattedMove = "";
		String column = "";
		String row = " " + String.valueOf(move[1]);
		
		if (playerColorInt == 1) {
			//player is BLACK
			formattedMove += "B";
		}
		else {
			//player is WHITE
			formattedMove += "W";
		}
		
		
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
		
		
		return formattedMove;
	}
	
	public boolean gameOver() {
		boolean fullBoard = true;
		
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				if (this.getBoardArray()[i][j] == 0) {
					fullBoard = false;
				}
			}
		}
		
		return fullBoard;
	}
	
	public int[] getScore() {
		int whiteScore = 0;
		int blackScore = 0;
		int[] score = new int[2];
		
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				if (this.getBoardArray()[i][j] == 1) {
					blackScore += 1;
				}
				else if (this.getBoardArray()[i][j] == -1) {
					whiteScore += 1;
				}
			}
		}
		score[0] = blackScore;
		score[1] = whiteScore;
		return score;
	}
	
	public String getOpponentMove() {
		String move;
		
		Scanner in = new Scanner(System.in);
		
		move = in.nextLine();
		
		return move;
	}
	
	public int[][] getBoardArray() {
		return boardArray;
	}

	public static void setBoardArray(int[][] boardArray) {
		Board.boardArray = boardArray;
	}

	/**
	 * 
	 * Private helper method for @printBoard method to convert integer value of
	 * pieces to String values.
	 * 
	 * @param integer value representation of pieces. W = -1, B = 1
	 * @return string value of pieces (either W for white, B for black, or $ for border)
	 */
	private String integerToLetter(int integer) {
		if (integer == -1) {
			return "W";
		}
		else if (integer == 1) {
			return "B";
		}
		else if (integer == 2) {
			return "$";
		}
		else {
			return "0";
		}
	}
	
	/**
	 * Print the current state of the game board to the standard console.
	 */
	public void printBoard() {
		//System.out.println("Running board.printBoard() method...");
		//System.out.println("Black = 1 | White = -1");
		//System.out.println();
		
		for (int i = 0; i < 9; i++) {
			
			if(i == 0) {
				System.out.print("*   ");
			}
			
			else {
				//utilizing UNICODE to label the top border
				System.out.print(Character.toChars('a'+i-1));
			}
			
			System.out.print(" ");
		}
		
		System.out.println();
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			
			if(i == 0 || i == 9) {
				System.out.print("   ");
			}
			else {
				System.out.print(i + "  ");
			}
			
			
			for (int j = 0; j < 10; j++) {
				
				System.out.print(integerToLetter(boardArray[j][i]) + " ");
			}
			
			System.out.println();
		}
	}

}
