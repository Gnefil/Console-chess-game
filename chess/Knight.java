package chess;

public class Knight extends Piece {

    Knight (PieceColour colourIn) {
        this.colour = colourIn;
    }

    public boolean isLegitMove(int iOri, int jOri, int iDes, int jDes) {
        //Initialise conditions as false
        boolean isLegit = false;
        boolean isDestCoordLegit = false;
        boolean isDestPlaceble  = false;
        boolean noObstacles = false;


        //Coordinates adequates to piece
        if (((Math.abs(iOri-iDes) == 2) && (Math.abs(jOri-jDes) == 1)) || ((Math.abs(iOri-iDes) == 1) && (Math.abs(jOri-jDes) == 2))) {
            isDestCoordLegit = true;
           }

        //Destination should not have our own piece
        if (!Board.hasPiece(iDes, jDes) || Board.getPiece(iDes, jDes).colour != this.colour) {
            isDestPlaceble = true;
        }

        //No pieces in the trajectory
        if (true) {
            noObstacles = true;
        }
        
        //Is legit if all true
        if (isDestCoordLegit && isDestPlaceble && noObstacles) {
            isLegit = true;
        }

		return isLegit;

	}

}
