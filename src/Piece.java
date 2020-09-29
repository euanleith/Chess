public abstract class Piece {
    public Side side;

    abstract boolean canMove(Point currentPoint, Point nextPoint, Piece[][] board);

    enum Side {
        BLACK(1),
        WHITE(-1);

        int weight;
        Side(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    public Piece(Side side) {
        this.side = side;
    }

    public static boolean isRowEmpty(Point currentPoint, Point nextPoint, Piece[][] board) {
        int min = Math.min(currentPoint.x, nextPoint.x);
        int max = Math.max(currentPoint.x, nextPoint.x);
        for (int i = min + 1; i < max; i++) {
            if (board[i][currentPoint.y] != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isColumnEmpty(Point currentPoint, Point nextPoint, Piece[][] board) {
        int min = Math.min(currentPoint.y, nextPoint.y);
        int max = Math.max(currentPoint.y, nextPoint.y);
        for (int i = min + 1; i < max; i++) {
            if (board[currentPoint.x][i] != null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDiagRightEmpty(Point currentPoint, Point nextPoint, Piece[][] board) {
        Point min = new Point(currentPoint.x, currentPoint.y);
        Point max = new Point(nextPoint.x, nextPoint.y);
        if (currentPoint.x > nextPoint.x) {
            min = max;
            max = new Point(currentPoint.x, currentPoint.y);
        }
        int y = min.y;
        for (int x = min.x + 1; x < max.x; x++) {
            if (board[x][y] != null) {
                return false;
            }
            y++;
        }
        return true;
    }

    public static boolean isDiagLeftEmpty(Point currentPoint, Point nextPoint, Piece[][] board) {
        Point start = new Point(currentPoint.x, currentPoint.y);
        Point end = new Point(nextPoint.x, nextPoint.y);
        if (currentPoint.x < nextPoint.x) {
            start = end;
            end = new Point(currentPoint.x, currentPoint.y);
        }
        int y = start.y;
        for (int x = start.x + 1; x < end.x; x++) {
            if (board[x][y] != null) {
                return false;
            }
            y--;
        }
        return true;
    }

    /*public static boolean ifMoved(Point currentPoint) {
        if ((currentPoint.x == 0 || currentPoint.x == 7) &&
                (currentPoint.y == 0 || currentPoint.y == 7) ||
                (currentPoint.x == 4 && (currentPoint.y == 0 || currentPoint.y == 7))) {
            return true;
        }
        return false;
    }

    enum Type {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        CASTLE,
        PAWN;
    }

    abstract Type getType();*/
}
