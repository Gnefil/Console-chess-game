package chess;

public class Bishop extends Piece {
    
    Bishop (PieceColour colourIn) {
        this.colour = colourIn;
    }

    public boolean isLegitMove(int iOri, int jOri, int iDes, int jDes) {
        //Initialise conditions as false
        boolean isLegit = false;
        boolean isDestCoordLegit = false;
        boolean isDestPlaceble  = false;
        boolean noObstacles = false;


        //Coordinates adequates to piece
        if (Math.abs(iOri-iDes) == Math.abs(jOri-jDes)) {
            isDestCoordLegit = true;
        }

        //Destination should not have our own piece
        if (!Board.hasPiece(iDes, jDes) || Board.getPiece(iDes, jDes).colour != this.colour) {
            isDestPlaceble = true;
        }

        //No pieces in the trajectory
        //Initialise noObstacles with true, if obstacle detected, than turn to false
        noObstacles = true;
        // Determine the direction of the movement, with the board as the console shows
        String direction = "";
        if ((iOri-iDes > 0) && (jOri-jDes > 0)) {
            direction = "NW";
        } else if ((iOri-iDes > 0) && (jOri-jDes < 0)) {
            direction = "NE";
        } else if ((iOri-iDes < 0) && (jOri-jDes > 0)) {
            direction = "SW";
        } else if ((iOri-iDes < 0) && (jOri-jDes < 0)){
            direction = "SE";
        }
        //Loop through the trajectory of the movement, if has a piece in any of them, then set noObstacles to false
        for (int i = 1; i < Math.abs(iOri-iDes); i++) {
            switch(direction) {
                case "NW": if (Board.hasPiece(iOri-i, jOri-i)) {noObstacles = false;} break;
                case "NE": if (Board.hasPiece(iOri-i, jOri+i)) {noObstacles = false;} break;
                case "SW": if (Board.hasPiece(iOri+i, jOri-i)) {noObstacles = false;} break;
                case "SE": if (Board.hasPiece(iOri+i, jOri+i)) {noObstacles = false;} break;
                case "":
            }
        }
        
        //Is legit if all true
        if (isDestCoordLegit && isDestPlaceble && noObstacles) {
            isLegit = true;
        }

		return isLegit;

	}

}
