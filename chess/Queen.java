package chess;

public class Queen extends Piece {

    Queen (PieceColour colourIn) {
        this.colour = colourIn;
    }

    public boolean isLegitMove(int iOri, int jOri, int iDes, int jDes) {
        //Initialise conditions as false
        boolean isLegit = false;
        boolean isDestCoordLegit = false;
        boolean isDestPlaceble  = false;
        boolean noObstacles = false;

        //Determine which kind of movement it uses, b for Bishop, r for Rook
        char movement = '\0';
        

        //Coordinates adequates to piece, and specify the movement used
        if (Math.abs(iOri-iDes) == Math.abs(jOri-jDes)) {
            isDestCoordLegit = true;
            movement = 'b';
        } else if (((iOri-iDes) == 0) || ((jOri-jDes) == 0)) {
            isDestCoordLegit = true;
            movement = 'r';
        }

        //Destination should not have our own piece
        if (!Board.hasPiece(iDes, jDes) || Board.getPiece(iDes, jDes).colour != this.colour) {
            isDestPlaceble = true;
        }

        //No pieces in the trajectory
        //Depends on the kind of movement, use bishop/rook noObstacles detection
        //Intialise noObstacles with true
        noObstacles = true;
        if (movement == 'b') {

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
        } else if (movement == 'r') {

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
        }
        
        //Is legit if all true
        if (isDestCoordLegit && isDestPlaceble && noObstacles) {
            isLegit = true;
        }

		return isLegit;

	}

}
