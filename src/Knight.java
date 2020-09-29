public class Knight extends Piece {

    @Override
    boolean canMove(Point currentPoint, Point nextPoint, Piece[][] board) {
        /*
        up&left
        up&right
        down&left
        down&right
        right&up
        right&down
        left&up
        left&down
         */
        if ((nextPoint.x - currentPoint.x == 1 && nextPoint.y - currentPoint.y == 2) ||//up&left
                (currentPoint.x - nextPoint.x == 1 && nextPoint.y - currentPoint.y == 2) ||//up&right
                (nextPoint.x - currentPoint.x == 1 && currentPoint.y - nextPoint.y == 2) ||//down&left
                (currentPoint.x - nextPoint.x == 1 && currentPoint.y - nextPoint.y == 2) ||//down&right
                (nextPoint.x - currentPoint.x == 2 && nextPoint.y - currentPoint.y == 1) ||//right&up
                (nextPoint.x - currentPoint.x == 2 && currentPoint.y - nextPoint.y == 1) ||//right&down
                (currentPoint.x - nextPoint.x == 2 && nextPoint.y - currentPoint.y == 1) ||//left&up
                (currentPoint.x - nextPoint.x == 2 && currentPoint.y - nextPoint.y == 1)   //left&down
                ) {
            return true;
        }
        return false;
    }

    public Knight(Side side) {
        super(side);
    }

    @Override
    public String toString() {
        return "H";
    }
}
