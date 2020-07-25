package othellobot;

import java.util.Scanner;

/**
 * 
 * The OthelloRun class will receive inputs from the referee program,
 * initialize the appropriate classes to play the game, and has the main method
 * to run the program.
 * 
 * @author Austin Howard
 * @version 1.1
 * @since 2019-08-29
 *
 */
public class OthelloRun {

	public static void main(String[] args) {
		//TODO test game over implementation on server
		//TODO clean up game over function to just come from the game class
		
		
		int currentPlayer = 1; //BLACK
		int ME = 1;
		int OPPONENT = -1;
		
		Player player1 = new Player();
		Player player2 = new Player();
		Board board = new Board();
		Game game = new Game(board, player1, player2);
		
		
		String myColor;
		myColor = getMyColor(); //receive input from standard input for which color to play as
		
		
		if (myColor.compareTo("I B") == 0) { 	//initialize as BLACK
			game.player1.receiveInput("I B"); 	//tell player to initialize as BLACK
			System.out.println("R B"); 			//output that player is ready to play as BLACK
			game.player2.receiveInput("I W"); 	//opponent (player2) will now initialize as WHITE
			currentPlayer = ME; 				//BLACK player always goes first so set current player to ME
		}
		else {
			game.player1.receiveInput("I W");
			System.out.println("R W");
			game.player2.receiveInput("I B");
			currentPlayer = OPPONENT;
		}
		
		
		while (!game.board.gameOver() || game.playersHaveNoMoves() == true) { //game loop with end game conditions
			if (currentPlayer == ME) {
				Move move = player1.chooseMove(game.player1.findPossibleMoves(board, player1)); //choose move from possible moves
				System.out.println(move.getMoveString() ); //print formatted move to standard output
				game.board.receiveMove(game.player1.sendMove(move.getMoveString() )); //send formatted move to the board
				game.board.printBoard(); //print the board
			}
			else {
				game.board.receiveMove(game.player2.sendMove(game.board.getOpponentMove())); //get opponent move from standard input and send to the game board
				game.board.printBoard(); //print the board
			}
			currentPlayer = currentPlayer*-1; //switch current player (game turns)
		}
		
		int[] score = game.board.getScore(); //once game is over, print the score of the game
		System.out.println("Final Score --- Black: " + score[0] + " White: " + score[1]);
		
		
		
	}
	
	/**
	 * Method used to get which color to initialize the program as at the beginning of the game
	 * @return a string from standard input, either "I B" or "I W".
	 */
	public static String getMyColor() {
		String color;
		
		Scanner in = new Scanner(System.in);
		
		color = in.nextLine();
		
		return color;
	}

}
