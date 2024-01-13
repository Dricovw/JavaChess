import java.util.Scanner;
import pieces.ChessPiece;
import pieces.PieceFactory;

public class ChessGame {
    private static ChessPiece[][] chessboard;
    private boolean isWhiteTurn;

        public ChessGame() {
            initializeChessboard();
            isWhiteTurn = true;
        }

        private void initializeChessboard() {
            chessboard = new ChessPiece[8][8];
            chessboard[0][0] = PieceFactory.createPawn('p');
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
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                displayChessboard();
                System.out.println(isWhiteTurn ? "White's turn" : "Black's turn");
                System.out.print("Enter your move (e.g., e2 to e4): ");
                System.out.print(numberToPosition(5, 5));
                System.out.print(positionToNumber("e5"));
                String move = scanner.nextLine();

                if (PieceMove.isValidMove(move)) {
                    PieceMove.makeMove(move);
                    isWhiteTurn = !isWhiteTurn;  // works
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

        }

    public static String positionToNumber(String position) {
        char file = position.charAt(0);
        int rank = Character.getNumericValue(position.charAt(1));

        // Check if the position is within the chessboard bounds
        if (file >= 'a' && file <= 'h' && rank >= 0 && rank <= 7) {
//            return chessboard[row][col].getSymbol();
           return file + "" + rank;
        } else {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    public static String numberToPosition(int col, int row) {
        char file = (char) ('a' + col);
        int rank = row + 1;

        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            return String.valueOf(file) + rank;
        } else {
            throw new IllegalArgumentException("Invalid position: ");
        }
    }

    public static char positionToPiece(String position) {
        int row = Integer.parseInt(position.substring(1, 2)) - 1;
        int col = position.charAt(0) - 'a';

        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            return chessboard[row][col].getSymbol();
        } else {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }



    private void displayChessboard() {
        System.out.println("  a b c d e f g h");
        System.out.println(" +----------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = chessboard[i][j];
                System.out.print(piece != null ? piece.getSymbol() + " " : "  ");  // Check for null
            }
            System.out.println("| " + (i + 1));
        }
        System.out.println(" +----------------");
        System.out.println("  a b c d e f g h");
    }


    }
