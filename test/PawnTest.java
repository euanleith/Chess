import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PawnTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testCantJump() {
        Piece[][] board = new Piece[8][8];
        board[1][5] = new Knight(Piece.Side.WHITE);
        board[1][6] = new Pawn(Piece.Side.WHITE);
        Point currentPoint = new Point(1, 6);
        Point nextPoint = new Point(1, 4);
        boolean result = board[1][6].canMove(currentPoint, nextPoint, board);
        Assertions.assertFalse(result);
    }

    @Test
    public void testPCanJump() {
        Piece[][] board = new Piece[8][8];
        board[1][6] = new Pawn(Piece.Side.WHITE);
        Point currentPoint = new Point(1, 6);
        Point nextPoint = new Point(1, 4);
        boolean result = board[1][6].canMove(currentPoint, nextPoint, board);
        Assertions.assertTrue(result);
    }

    @Test
    public void testPCantMoveRight() {
        Piece[][] board = new Piece[8][8];
        board[1][6] = new Pawn(Piece.Side.WHITE);
        Point currentPoint = new Point(1, 6);
        Point nextPoint = new Point(2, 6);
        boolean result = board[1][6].canMove(currentPoint, nextPoint, board);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCCanMove() {
        Piece[][] board = new Piece[8][8];
        board[4][4] = new Castle(Piece.Side.WHITE);
        Point currentPoint = new Point(4, 4);
        Point nextPoint = new Point(4, 6);
        boolean result = board[4][4].canMove(currentPoint, nextPoint, board);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCCanJump() {
        Piece[][] board = new Piece[8][8];
        board[4][4] = new Castle(Piece.Side.WHITE);
        board[4][2] = new Pawn(Piece.Side.WHITE);
        Point currentPoint = new Point(4, 4);
        Point nextPoint = new Point(4, 1);
        boolean result = board[4][4].canMove(currentPoint, nextPoint, board);
        Assertions.assertFalse(result);
    }

    @Test
    public void testBCanMove() {
        Piece[][] board = new Piece[8][8];
        board[4][4] = new Bishop(Piece.Side.WHITE);
        Point currentPoint = new Point(4, 4);
        Point nextPoint = new Point(3, 5);
        boolean result = board[4][4].canMove(currentPoint, nextPoint, board);
        Assertions.assertTrue(result);
    }

    @Test
    public void testQCanMove() {
        Piece[][] board = new Piece[8][8];
        board[4][4] = new Queen(Piece.Side.WHITE);
        Point currentPoint = new Point(4, 4);
        Point nextPoint = new Point(4, 5);
        boolean result = board[4][4].canMove(currentPoint, nextPoint, board);
        Assertions.assertTrue(result);
    }
}
