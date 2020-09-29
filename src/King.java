public class King extends Piece {
    boolean hasMoved = false;

    @Override
    boolean canMove(Point currentPoint, Point nextPoint, Piece[][] board) {
        if (nextPoint.x - currentPoint.x == 1 ||
                nextPoint.y - currentPoint.y == 1 ||
                currentPoint.x - nextPoint.x == 1 ||
                currentPoint.y - nextPoint.y == 1) {
            hasMoved = true;
            return true;
        }/*
        else if () {

            if king and castle have never moved,
            king->w:c1/g1 or b: c8/g8,
            castle of correct side
            not piece in the way

            if (!hasMoved && !castle.hasMoved && side == castle.side &&
                    (nextPoint.x == 2 || nextPoint.x == 6) &&
                            ((side == Piece.Side.WHITE && nextPoint.y == 7 ) ||
                            (side == Piece.Side.BLACK && nextPoint.y == 0))){
                //move castle
                return true;
            }
            if (nextPoint.x == 2 && (side == Piece.Side.WHITE && nextPoint.y == 7) && !hasMoved &&
                    validCastle(board[0][7])) {
                hasMoved = true;
            }
        }*/
        return false;
    }

    public King(Side side) {
        super(side);
    }

    @Override
    public String toString() {
        return "K";
    }

    /*boolean validCastle(Piece piece) {
        if (piece != null &&
                piece == Piece.Type.CASTLE &&
                Side == side) {
            return true;
        }
        return false;
    }*/
}
