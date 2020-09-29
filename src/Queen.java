public class Queen extends Piece {
    @Override
    boolean canMove(Point currentPoint, Point nextPoint, Piece[][] board) {
        if (((nextPoint.x == currentPoint.x && isRowEmpty(currentPoint, nextPoint, board)||
                nextPoint.y == currentPoint.y) && isColumnEmpty(currentPoint, nextPoint, board)) ||
                ((nextPoint.x - currentPoint.x == nextPoint.y - currentPoint.y && Piece.isDiagRightEmpty(currentPoint, nextPoint, board)) ||
                        ((currentPoint.x - nextPoint.y == nextPoint.x - currentPoint.y) && Piece.isDiagLeftEmpty(currentPoint, nextPoint, board)))) {
            return true;
        }
        return false;
    }

    public Queen(Side side) {
        super(side);
    }

    @Override
    public String toString() {
        return "Q";
    }
}
