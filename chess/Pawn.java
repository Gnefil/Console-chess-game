package chess;

public class Pawn extends Piece {
    
    Pawn (PieceColour colourIn) {
        this.colour = colourIn;
    }

    public boolean isLegitMove(int iOri, int jOri, int iDes, int jDes) {
        //Initialise conditions as false
        boolean isLegit = false;
        boolean isDestCoordLegit = false;
        boolean isDestPlaceble  = false;
        boolean noObstacles = false;

        //Should the pawn capture?
        boolean shouldDouble = false;
        boolean shouldCapture = false;


        //Coordinates adequates to piece
        //Depends on colour
        if (this.colour == PieceColour.WHITE) {
            //Moving forward
            if ((jOri-jDes == 0) && (iOri-iDes == 1)) {
                isDestCoordLegit = true;
            } else if ((Math.abs(jOri-jDes) == 1) && (iOri-iDes == 1)) {
                //Captures in this case
                shouldCapture = true;
                isDestCoordLegit = true;
            } else if ((iOri == 6) && (Math.abs(iOri-iDes) == 2)) {
                //First move allows double the distance
                shouldDouble = true;
                isDestCoordLegit = true;
            }

        } else if (this.colour == PieceColour.BLACK) {
            //Moving forward
            if ((jOri-jDes == 0) && (iOri-iDes == -1)) {
                isDestCoordLegit = true;
            } else if ((Math.abs(jOri-jDes) == 1) && (iOri-iDes == -1)) {
                //Captures in this case
                shouldCapture = true;
                isDestCoordLegit = true;
            } else if ((iOri == 1) && (Math.abs(iOri-iDes) == 2)) {
                //First move allows double the distance
                shouldDouble = true;
                isDestCoordLegit = true;
            }
            
        }

        //Destination should not have our own piece

        //Case which destination has no piece and pawn shouldn't capture because of moving diagonally
        if (!Board.hasPiece(iDes, jDes) && (!shouldCapture)) {
            isDestPlaceble = true;
        } 
        //Case which destination has piece (not same colour), and pawn should capture as moves digonally
        else if (Board.hasPiece(iDes, jDes)) {
            if ((Board.getPiece(iDes, jDes).colour != this.colour) && shouldCapture) {
            isDestPlaceble = true;
            }
        }

        //No pieces in the trajectory
        if (shouldCapture || !shouldDouble) {
            noObstacles = true;
        } else if (shouldDouble) {

            //Depending on the colour
            //If white
            if ((iOri == 6) && (!Board.hasPiece(iOri-1, jOri))) {
                noObstacles = true;
            } else if ((iOri == 1) && (!Board.hasPiece(iOri+1, jOri))) {
                //If black
                noObstacles = true;
            }
            
        }
        
        //Is legit if all true
        if (isDestCoordLegit && isDestPlaceble && noObstacles) {
            isLegit = true;
        }

		return isLegit;

	}
	
}
