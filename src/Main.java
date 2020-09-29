import java.util.Scanner;
//highlight selected piece

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        //pawn->queen
        //option to take back move
        //could inc. timing thing
        Piece[][] board = new Piece[8][8];
        King whiteKing = new King(Piece.Side.WHITE);
        King blackKing = new King(Piece.Side.BLACK);
        fillBoard(board, whiteKing, blackKing);

        boolean gamer = true;
        Piece.Side side = Piece.Side.BLACK;
        while (gamer) {
            String sideString;
            if (side == Piece.Side.BLACK) {
                side = Piece.Side.WHITE;
                sideString = "White";
            }
            else {
                side = Piece.Side.BLACK;
                sideString = "Black";
            }

            printBoard(board);
            Scanner scan = new Scanner(System.in);
            Point currentPoint;
            do {
                System.out.print("(" + sideString + ") Which piece? ");
                String currentPos = scan.next();
                currentPoint = findPos(currentPos);
            } while (currentPoint == null ||
                    board[currentPoint.x][currentPoint.y] == null ||
                    board[currentPoint.x][currentPoint.y].side != side);
            //&&!canMove, or choice to change move
            //boolean hasMoved[piece] = Piece.ifMoved(currentPoint);

            Point nextPoint;
            boolean validMove = false;
            String chosenPiece = board[currentPoint.x][currentPoint.y].toString();
            String takenPiece;
            do {
                System.out.print("Where to? ");
                String nextPos = scan.next();
                //if ("back")
                nextPoint = findPos(nextPos);
                if (nextPoint != null) {
                    if (board[nextPoint.x][nextPoint.y] == null) {
                        validMove = movePiece(currentPoint, nextPoint, board);
                    }
                    else if (board[nextPoint.x][nextPoint.y].side != side) {
                        takenPiece = board[nextPoint.x][nextPoint.y].toString();
                        if ((board[nextPoint.x][nextPoint.y] == whiteKing) ||
                                (board[nextPoint.x][nextPoint.y] == blackKing)) {
                            System.out.print("Game Over\n" + sideString + " wins!");
                            gamer = false;
                            validMove = true;
                        }
                        //thats not really how chess works; checkmate etc.
                        else {
                            System.out.println(chosenPiece + " takes " + takenPiece);
                            validMove = movePiece(currentPoint, nextPoint, board);
                        }
                    }
                }
            } while (!validMove);
        }

    }

    public static void fillBoard(Piece[][] board, King whiteKing, King blackKing) {
        board[0][0] = new Castle(Piece.Side.BLACK);
        board[1][0] = new Knight(Piece.Side.BLACK);
        board[2][0] = new Bishop(Piece.Side.BLACK);
        board[3][0] = new Queen(Piece.Side.BLACK);
        board[4][0] = blackKing;
        board[5][0] = new Bishop(Piece.Side.BLACK);
        board[6][0] = new Knight(Piece.Side.BLACK);
        board[7][0] = new Castle(Piece.Side.BLACK);
        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn(Piece.Side.BLACK);
        }

        board[0][7] = new Castle(Piece.Side.WHITE);
        board[1][7] = new Knight(Piece.Side.WHITE);
        board[2][7] = new Bishop(Piece.Side.WHITE);
        board[3][7] = new Queen(Piece.Side.WHITE);
        board[4][7] = whiteKing;
        board[5][7] = new Bishop(Piece.Side.WHITE);
        board[6][7] = new Knight(Piece.Side.WHITE);
        board[7][7] = new Castle(Piece.Side.WHITE);
        for (int i = 0; i < 8; i++) {
            board[i][6] = new Pawn(Piece.Side.WHITE);
        }
    }
    public static void printBoard(Piece[][] board) {
        System.out.print("\n  ");
        for (int j = 0; j < board.length; j++) {
            System.out.print((char) (j + 65) + " ");
        }
        for (int j = 0; j < board.length; j++) {
            System.out.print("\n" + (j + 1) + " ");
            for (int i = 0; i < board[j].length; i++) {
                if (board[i][j] == null) {
                    System.out.print("- ");
                }
                else {
                    String colour = ANSI_PURPLE;
                    if (board[i][j].side == Piece.Side.WHITE) {
                        colour = ANSI_BLACK;
                    }
                    System.out.print(colour + board[i][j] + ANSI_RESET + " ");
                }
            }
        }
        System.out.println("\n");
    }

    public static Point findPos(String pos) {
        int x = pos.charAt(0) - 65;
        int y = Integer.valueOf(pos.substring(1)) - 1;
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            return new Point(x, y);
        }
        return null;
    }

    public static boolean movePiece(Point currentPoint, Point nextPoint, Piece[][] board) {
        Piece piece = board[currentPoint.x][currentPoint.y];
        if (piece.canMove(currentPoint, nextPoint, board)) {
            board[currentPoint.x][currentPoint.y] = null;
            board[nextPoint.x][nextPoint.y] = piece;
            return true;
        }
        return false;
    }
}
