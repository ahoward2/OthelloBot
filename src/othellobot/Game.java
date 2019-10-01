package othellobot;

/**
 * 
 * The Game class will handle the state of the game and will allows the Player
 * class to interface will the current state of moves in order to identify
 * legal moves, whether the game has ended, and information about the board
 * in order to calculate next moves.
 * 
 * @author Austin Howard
 * @version 1.0
 * @since 2019-08-29
 *
 */
public class Game {
	
	Board board;
	Player player1;
	Player player2;
	
	Game(Board board, Player player1, Player player2){
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * Based on the commands received, this function should call the
	 * appropriate commands to update the state of the game board.
	 * 
	 * @param input to be received in String format
	 */
	
	public boolean playersHaveNoMoves() {
		boolean noMoves = false;
		
		if (this.player1.hasValidMoves == false && this.player2.hasValidMoves == false) {
			noMoves = true;
		}
		
		return noMoves;
	}
	
	
	public static void receiveInput(String input) {
		
		/*
		 * Need to find a way to interpret these moves
		 * Example: "B a 2" means Black moves to column a, row 2
		 * 
		 * if (input == "B c r") {
			//inform the program that Black moves to column c, row r
		}
		 */
		
		if (input == "B") {
			//inform the program that Black passes
		}
		
		/*
		 * Need to find a way to interpret these moves
		 * Example: "W a 2" means White moves to column a, row 2
		 * 
		 * if (input == "W c r") {
			//inform the program that White moves to column c, row r
		}
		 */
		
		if (input == "W") {
			//inform the program that White passes
		}
		
		/*
		 * Need to find a way to interpret this command
		 * 
		 * if (input == "C String") {
			//A comment has been made. Referee is to ignore!
		}
		 */
		
		if (input == "n") {
			//Other program claiming end game!!! Check it out!! n is the
			//number of black pieces on the board
		}
		
	}
}
