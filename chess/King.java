package chess;

import java.lang.Math;

public class King extends Piece {

    King (PieceColour colourIn) {
        this.colour = colourIn;
    }

    public boolean isLegitMove(int iOri, int jOri, int iDes, int jDes) {
        //Initialise conditions as false
        boolean isLegit = false;
        boolean isDestCoordLegit = false;
        boolean isDestPlaceble  = false;
        boolean noObstacles = false;


        //Coordinates adequates to piece
        if (((Math.abs(iOri-iDes) == 0) || (Math.abs(iOri-iDes) == 1)) && ((Math.abs(jOri-jDes) == 0) || (Math.abs(jOri-jDes) == 1))) {
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
