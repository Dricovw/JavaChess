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
            chessboard[0][0] = PieceFactory.createPawn('p');
            chessboard[7][7] = PieceFactory.createRook('R');
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


                String move = scanner.nextLine();

                if (PieceMove.isValidMove(move)) {
                    PieceMove.makeMove(move);
                    isWhiteTurn = !isWhiteTurn;  // works
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

        }

    public static char getPieceAtPosition(String position) {
        int row = Integer.parseInt(position.substring(1, 2)) - 1;
        int col = position.charAt(0) - 'a';


        // Check if the position is within the chessboard bounds
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
                Piece piece = chessboard[i][j];
                System.out.print(piece != null ? piece.getSymbol() + " " : "  ");  // Check for null
            }
            System.out.println("| " + (i + 1));
        }
        System.out.println(" +----------------");
        System.out.println("  a b c d e f g h");
    }


    }
