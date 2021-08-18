package chess;

public class Rook extends Piece {

    Rook (PieceColour colourIn) {
        this.colour = colourIn;
    }

    public boolean isLegitMove(int iOri, int jOri, int iDes, int jDes) {
        //Initialise conditions as false
        boolean isLegit = false;
        boolean isDestCoordLegit = false;
        boolean isDestPlaceble  = false;
        boolean noObstacles = false;

        //Coordinates adequates to piece
        if (((iOri-iDes) == 0) || ((jOri-jDes) == 0)) {
            isDestCoordLegit = true;
        }

        //Destination should not have our own piece
        if (!Board.hasPiece(iDes, jDes) || Board.getPiece(iDes, jDes).colour != this.colour) {
            isDestPlaceble = true;
        }

        //No pieces in the trajectory
        //Initialise noObstacles as true
        noObstacles = true;
        // Determine the direction of the movement, with the board as the console shows
        String direction = "";
        if (iOri-iDes > 0) {
            direction = "N";
        } else if (iOri-iDes < 0) {
            direction = "S";
        } else if (jOri-jDes > 0) {
            direction = "W";
        } else if (jOri-jDes < 0){
            direction = "E";
        }
        //Loop through the trajectory of the movement, if has a piece in any of them, then set noObstacles to false
        if ((iOri-iDes) != 0) {
            for (int i = 1; i < Math.abs(iOri-iDes); i++) {
                switch(direction) {
                    case "N": if (Board.hasPiece(iOri-i, jOri)) {noObstacles = false;} break;
                    case "S": if (Board.hasPiece(iOri+i, jOri)) {noObstacles = false;} break;
                    case "":
                }
            }
        } else if ((jOri-jDes) != 0) {
            for (int i = 1; i < Math.abs(jOri-jDes); i++) {
                switch(direction) {
                    case "W": if (Board.hasPiece(iOri, jOri-1)) {noObstacles = false;} break;
                    case "E": if (Board.hasPiece(iOri, jOri+1)) {noObstacles = false;} break;
                    case "":
                }
            }
        }

        
        //Is legit if all true
        if (isDestCoordLegit && isDestPlaceble && noObstacles) {
            isLegit = true;
        }

		return isLegit;

	}

}
