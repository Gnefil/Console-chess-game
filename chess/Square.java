package chess;

//This class requires your input
public class Square {
	private boolean hasPiece;
	private Piece p;

	public Piece getPiece() {
		return p;
	}

	public void setPiece(Piece pieceIn) {
		p = pieceIn;
	}

	public void removePiece() {
		p = null;
	}
	
	public boolean hasPiece(){
		if (this.getPiece() != null) {
			this.hasPiece = true;
		} else {
			this.hasPiece = false;
		}
		return hasPiece;
	}	
}
