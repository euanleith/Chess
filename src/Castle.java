public class Castle extends Piece {
    boolean hasMoved = false;

    @Override
    boolean canMove(Point currentPoint, Point nextPoint, Piece[][] board) {
        if ((nextPoint.x == currentPoint.x && isRowEmpty(currentPoint, nextPoint, board)||
                nextPoint.y == currentPoint.y) && isColumnEmpty(currentPoint, nextPoint, board)) {
            return true;
        }
        return false;
    }

    public Castle(Side side) {
        super(side);
    }

    @Override
    public String toString() {
        return "C";
    }
}
