package chess;


//This class is partially implemented
public class Board {
	private static Square [][] board = new Square[8][8];

	//This method should not be edited
	public static void initialiseBoard(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square();
		}
	}
    
	//This method requires your input	
	public static void initialisePieces(){

		// Intialise all pieces of the game, name given by colour (first letter) + type
		Rook bRook = new Rook(PieceColour.BLACK);
		Knight bKnight = new Knight(PieceColour.BLACK);
		Bishop bBishop = new Bishop(PieceColour.BLACK);
		Queen bQueen = new Queen(PieceColour.BLACK);
		King bKing = new King(PieceColour.BLACK);
		Pawn bPawn = new Pawn(PieceColour.BLACK);

		Rook wRook = new Rook(PieceColour.WHITE);
		Knight wKnight = new Knight(PieceColour.WHITE);
		Bishop wBishop = new Bishop(PieceColour.WHITE);
		Queen wQueen = new Queen(PieceColour.WHITE);
		King wKing = new King(PieceColour.WHITE);
		Pawn wPawn = new Pawn(PieceColour.WHITE);

		//Give symbols to each piece
		bRook.setSymbol("\u265C");
		bKnight.setSymbol("\u265E");
		bBishop.setSymbol("\u265D");
		bQueen.setSymbol("\u265B");
		bKing.setSymbol("\u265A");
		bPawn.setSymbol("\u265F");

		wRook.setSymbol("\u2656");
		wKnight.setSymbol("\u2658");
		wBishop.setSymbol("\u2657");
		wQueen.setSymbol("\u2655");
		wKing.setSymbol("\u2654");
		wPawn.setSymbol("\u2659");

				
		//Put the pieces inside Squares
		//Row 0 (index) for black multiple pieces
		for (int i = 0, j = 0; j<board[0].length; j++) {
			switch(j) {
				case 0: case 7: board[i][j].setPiece(bRook); break;
				case 1: case 6: board[i][j].setPiece(bKnight); break;
				case 2: case 5: board[i][j].setPiece(bBishop); break;
				case 3: board[i][j].setPiece(bQueen); break;
				case 4: board[i][j].setPiece(bKing); break;
			}
		}

		//Row 1 (index) for black pawns
		for (int i = 1, j =0; j<board[0].length; j++) {
			board[i][j].setPiece(bPawn);
		}

		//Row 6 (index) for white pawns
		for (int i = 6, j =0; j<board[0].length; j++) {
			board[i][j].setPiece(wPawn);
		}

		//Row 7 (index) for white multiple pieces
		for (int i = 7, j = 0; j<board[0].length; j++) {
			switch(j) {
				case 0: case 7: board[i][j].setPiece(wRook); break;
				case 1: case 6: board[i][j].setPiece(wKnight); break;
				case 2: case 5: board[i][j].setPiece(wBishop); break;
				case 3: board[i][j].setPiece(wQueen); break;
				case 4: board[i][j].setPiece(wKing); break;
			}
		}
		
	}
	
	//This method requires your input	
	public static void printBoard(){

		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");		
		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && Board.hasPiece(i,j))
						System.out.print(row+" "+Board.getPiece(i,j).getSymbol());	
					else if ((j==0) && !Board.hasPiece(i,j))
						System.out.print(row+"  " );
					else if (Board.hasPiece(i,j))					
						System.out.print("|"+Board.getPiece(i,j).getSymbol());					
					else					
						System.out.print("| ");		
				}				
				System.out.print("  "+row+"\n");
		}
		System.out.print("  -----------------");
		System.out.print("\n  a b c d e f g h \n");	

	}
	
	//This method requires your input	
	public static boolean movePiece(int i0, int j0, int i1, int j1, Piece p){

		boolean isKing = false;
		if ((Board.hasPiece(i1, j1) && ((board[i1][j1].getPiece().getSymbol() == "\u265A") || (board[i1][j1].getPiece().getSymbol() == "\u2654")))) {
			isKing = true;
		}
		board[i1][j1].setPiece(p);
		board[i0][j0].removePiece();
		return isKing;
	}

	//This method requires your input
	public static void setPiece(int iIn, int jIn, Piece p){

		board[iIn][jIn].setPiece(p);
	}
	
	//This method requires your input
	public static Piece getPiece(int iIn, int jIn){
		
		return board[iIn][jIn].getPiece();
	}
	
	//This method requires your input
	public static boolean hasPiece(int i, int j){

		return board[i][j].hasPiece();
	}

}
