public class Pawn extends Piece {

    @Override
    public boolean canMove(Point currentPoint, Point nextPoint, Piece[][] board) {
        /*
        Moves two spaces if hasn't moved before
        Moves one space otherwise
        Moves diagonal one space if there is someone there to take
         */
        boolean hasPiece = board[nextPoint.x][nextPoint.y] != null;
        int weight = side.getWeight();
        if (((nextPoint.y - currentPoint.y) * weight == 2 && nextPoint.x - currentPoint.x == 0 && (currentPoint.y == 1 || currentPoint.y == 6) &&
                board[currentPoint.x][currentPoint.y + weight] == null) ||//if nothing in between
                ((nextPoint.y - currentPoint.y) * weight == 1 && nextPoint.x - currentPoint.x == 0) ||
                ((nextPoint.y - currentPoint.y) * weight == 1 && nextPoint.x - currentPoint.x == 1 && hasPiece)) {
            return true;
        }
        return false;

    }

    public Pawn(Side side) {
        super(side);
    }

    @Override
    public String toString() {
        return "P";
    }
}
