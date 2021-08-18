package chess;

//This class requires your input
public abstract class Piece {
	private String symbol;
	protected PieceColour colour;

	public String getSymbol() {
		return symbol;
	}	

	public void setSymbol(String symbolIn) {
		this.symbol = symbolIn;
	}

	public PieceColour getColour () {
		return this.colour;
	}

	public abstract boolean isLegitMove(int iOri, int jOri, int iDes, int jDes);
}
