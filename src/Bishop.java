public class Bishop extends Piece {
    @Override
    boolean canMove(Point currentPoint, Point nextPoint, Piece[][] board) {
        if ((nextPoint.x - currentPoint.x == nextPoint.y - currentPoint.y && Piece.isDiagRightEmpty(currentPoint, nextPoint, board)) ||
                ((currentPoint.x - nextPoint.y == nextPoint.x - currentPoint.y) && Piece.isDiagLeftEmpty(currentPoint, nextPoint, board))) {
            return true;
        }
        return false;
    }

    public Bishop(Side side) {
        super(side);
    }

    @Override
    public String toString() {
        return "B";
    }
}