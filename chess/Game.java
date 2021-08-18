package chess;

import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){

		int turn = 0;
		PieceColour playerColour = PieceColour.WHITE;
		Console keyboardConsole = System.console();
		boolean correctOrigin = false;
		boolean correctDestination = false;
		String inputFromUser = "";
		CheckInput checkInput = new CheckInput();
		int oriI = 0;
		int oriJ = 0;
		int desI = 0;
		int desJ = 0;
		boolean legitMove = false;
		Piece pieceMoved = null;
		
		System.out.println("Remember to input coordinates using number + letter format! E.g. 5e, 4a");
		System.out.println("Type exactly END to resign and end the game as defeated");
		while (!gameEnd){

			//Identify the colour of current turn, which player is going to move
			turn += 1;
			if (turn%2 != 0) {
				playerColour = PieceColour.WHITE;
			} else {
				playerColour = PieceColour.BLACK;
			}

			//Encourage the corresponding player to move
			if (playerColour == PieceColour.WHITE) {
				System.out.println("╓──────────────────────────────────────╖");
				System.out.println("║             WHITE'S MOVE             ║");
				System.out.println("╙──────────────────────────────────────╜");
			} else {
				System.out.println("╓──────────────────────────────────────╖");
				System.out.println("║             BLACK'S MOVE             ║");
				System.out.println("╙──────────────────────────────────────╜");
			}

			//All included to test legitMove
			do {
				legitMove = false;

				//Taking original pair of coordinates
				do {
					correctOrigin = false;
					inputFromUser = keyboardConsole.readLine("Enter original coordinates:");
					System.out.println(inputFromUser);
					if (inputFromUser.equals("END")) {
						break;
					}
					inputFromUser = inputFromUser.replaceAll("\\s", "");
					inputFromUser = inputFromUser.toLowerCase();

					//Should be valid format
					if (checkInput.checkCoordinateValidity(inputFromUser)) {

						//Transforming coordinates into indexes
						oriI = ((int) inputFromUser.charAt(0)) - 49;			
						oriJ = ((int) inputFromUser.charAt(1)) - 97;		

						//Piece should exist in that square
						if (Board.hasPiece(oriI, oriJ)) {

							//Piece should belong to the same team
							if (Board.getPiece(oriI, oriJ).getColour() == playerColour) {

								correctOrigin = true;

							} else {
								System.out.println("Can't move opponents piece! Please re-enter!\n");
							}
						
						} else {
							System.out.println("Not piece found in these coordinates! Please re-enter!\n");
						}

					} else {
						System.out.println("Not valid coordinates! Please re-enter!\n");
					}

				} while (!correctOrigin);

				if (inputFromUser.equals("END")) {
					break;
				}

				//Taking destination pair of coordinates
				do {
					correctDestination = false;
					inputFromUser = keyboardConsole.readLine("Enter destination coordinates:");
					if (inputFromUser.equals("END")) {
						break;
					}
					inputFromUser = inputFromUser.replaceAll("\\s", "");
					inputFromUser = inputFromUser.toLowerCase();

					//Should be valid format
					if (checkInput.checkCoordinateValidity(inputFromUser)) {

						//Transforming coordinates into indexes
						desI = ((int) inputFromUser.charAt(0)) - 49;			
						desJ = ((int) inputFromUser.charAt(1)) - 97;		

						//Piece should be moved into a different place
						if ((oriI-desI) != 0 || (oriJ-desJ) !=0) {

							correctDestination = true;
						
						} else {
							System.out.println("Piece won't move with these coordinates! Please re-enter!\n");
						}

					} else {
						System.out.println("Not valid coordinates! Please re-enter!\n");
					}

				} while (!correctDestination);	
				if (inputFromUser.equals("END")) {
					break;
				}

				//Determine which piece is being moved
				pieceMoved = Board.getPiece(oriI, oriJ);

				//Test if it is a legit move

				legitMove = pieceMoved.isLegitMove(oriI, oriJ, desI, desJ);

				if (!legitMove) {
					System.out.println("This is not a legit move! Please re-enter the coordinates:\n");
				}

			} while (!legitMove);
			if (inputFromUser.equals("END")) {
				break;
			}

			//Check if the king is captured
			gameEnd = Board.movePiece(oriI, oriJ, desI, desJ, pieceMoved);

			System.out.println("Move completed\n\n");

			System.out.println("↓    ↓    ↓    ↓");

			Board.printBoard();

		}

		// Change the one that resigns to the opposite team for win-declaration 
		if (inputFromUser.equals("END")) {
			if(playerColour == PieceColour.BLACK) {
				playerColour = PieceColour.WHITE;
			} else if(playerColour == PieceColour.WHITE) {
				playerColour = PieceColour.BLACK;
			}
		} 
		
		System.out.println("END of the game!");

		if (playerColour == PieceColour.BLACK) {
			System.out.println("\nBLACK team's VICTORY!");
		} else if (playerColour == PieceColour.WHITE) {
			System.out.println("\nWHITE team's VICTORY!");
		}
	}
	
	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}

}
