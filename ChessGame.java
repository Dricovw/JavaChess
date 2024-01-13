import java.util.ArrayList;
import java.util.Scanner;
import pieces.Piece;
import pieces.PieceFactory;

public class ChessGame {
    private static Piece[][] chessboard;
    private boolean isWhiteTurn;

        public ChessGame() {
            initializeChessboard();
            isWhiteTurn = true;
        }

        private void initializeChessboard() {
            chessboard = new Piece[8][8];
            chessboard[7][7] = PieceFactory.createRook('R');
            chessboard[7][0] = PieceFactory.createRook('R');
            chessboard[0][7] = PieceFactory.createRook('r');
            chessboard[0][0] = PieceFactory.createRook('r');
            chessboard[7][5] = PieceFactory.createBishop('B');
            chessboard[7][2] = PieceFactory.createBishop('B');
            chessboard[0][5] = PieceFactory.createBishop('b');
            chessboard[0][2] = PieceFactory.createBishop('b');
            chessboard[7][6] = PieceFactory.createKnight('N');
            chessboard[7][1] = PieceFactory.createKnight('N');
            chessboard[0][6] = PieceFactory.createKnight('n');
            chessboard[0][1] = PieceFactory.createKnight('n');
            chessboard[7][4] = PieceFactory.createQueen('Q');
            chessboard[0][3] = PieceFactory.createQueen('q');
            chessboard[7][3] = PieceFactory.createKing('K');
            chessboard[0][4] = PieceFactory.createKing('k');
            for (int i = 0; i < 8; i++) {
                chessboard[1][i] = PieceFactory.createPawn('p');
            }
            for (int i = 0; i < 8; i++) {
                chessboard[6][i] = PieceFactory.createPawn('P');
            }
            chessboard[4][1] = PieceFactory.createKnight('N');
            chessboard[4][2] = PieceFactory.createBishop('B');
            chessboard[4][3] = PieceFactory.createKing('K');
            chessboard[4][4] = PieceFactory.createQueen('Q');
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                displayChessboard();
                System.out.println(isWhiteTurn ? "White's turn" : "Black's turn");
                System.out.print("Enter your move (e.g., e2 to e4): ");
//                System.out.print(ChessGame.getPieceAtPosition("b2"));
                String move = scanner.nextLine();

                if (PieceMove.isValidMove(move)) {
                    PieceMove.makeMove(move);
                    isWhiteTurn = !isWhiteTurn;  // works
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

        }

    public static char positionToNumber(String position) {
        int row = Integer.parseInt(position.substring(1, 2)) - 1;
        int col = position.charAt(0) - 'a';
        System.out.print(row);
        System.out.print(col);

        // Check if the position is within the chessboard bounds
        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            return chessboard[row][col].getSymbol();
        } else {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    public static String numberToPosition(int row, int col) {
        char file = (char) ('a' + col);
        int rank = 8 - row;

        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            return String.valueOf(file) + rank;
        } else {
            throw new IllegalArgumentException("Invalid position: ");
        }
    }


    private void displayChessboard() {
        System.out.println("  a b c d e f g h");
        System.out.println(" +----------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < 8; j++) {
                Piece piece = chessboard[i][j];
                System.out.print(piece != null ? piece.getSymbol() + " " : "  ");  // Check for null
            }
            System.out.println("| " + (i + 1));
        }
        System.out.println(" +----------------");
        System.out.println("  a b c d e f g h");
    }


    }
