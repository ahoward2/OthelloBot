package othellobot;

import java.util.Scanner;

/**
 * 
 * The OthelloRun class will receive inputs from the referee program,
 * initialize the appropriate classes to play the game, and has the main method
 * to run the program.
 * 
 * @author Austin Howard
 * @version 1.0
 * @since 2019-08-29
 *
 */
public class OthelloRun {

	public static void main(String[] args) {
		//TODO write script file and put .jar file on server
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
		myColor = getMyColor();
		
		
		if (myColor.compareTo("I B") == 0) {
			game.player1.receiveInput("I B");
			System.out.println("R B");
			game.player2.receiveInput("I W");
			currentPlayer = ME;
		}
		else {
			game.player1.receiveInput("I W");
			System.out.println("R W");
			game.player2.receiveInput("I B");
			currentPlayer = OPPONENT;
		}
		
		
		while (!game.board.gameOver() || game.playersHaveNoMoves() == true) {
			if (currentPlayer == ME) {
				int[] move = player1.chooseMove(game.player1.findPossibleMoves(board, player1));
				String formattedMove = (player1.formatMove(move, player1));
				System.out.println(formattedMove);
				game.board.receiveMove(game.player1.sendMove(formattedMove));
				game.board.printBoard();
			}
			else {
				game.board.receiveMove(game.player2.sendMove(game.board.getOpponentMove()));
				game.board.printBoard();
			}
			currentPlayer = currentPlayer*-1;
		}
		
		int[] score = game.board.getScore();
		System.out.println("Final Score --- Black: " + score[0] + " White: " + score[1]);
		
		
		
	}
	
	public static String getMyColor() {
		String color;
		
		Scanner in = new Scanner(System.in);
		
		color = in.nextLine();
		
		return color;
	}

}
