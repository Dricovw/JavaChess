import java.util.Scanner;
//package chess.game;

import pieces.Piece;
import pieces.PieceFactory;
public class ChessGame {
//        private char[][] chessboard;
private Piece[][] chessboard;

        private boolean isWhiteTurn;

        public ChessGame() {
            initializeChessboard();
            isWhiteTurn = true;
        }

        private void initializeChessboard() {
            chessboard = new Piece[8][8];
            chessboard[0][0] = PieceFactory.createPawn('p');
            chessboard[0][7] = PieceFactory.createRook('R');
            chessboard[0][6] = PieceFactory.createKnight('N');
            chessboard[0][5] = PieceFactory.createBishop('B');
            chessboard[0][4] = PieceFactory.createKing('K');
            chessboard[0][3] = PieceFactory.createQueen('Q');

//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    chessboard[i][j] = PieceFactory.createPawn('p');
//                }
//            }

//            chessboard = new char[][] {
//                    {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
//                    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
//                    {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
//            };
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                displayChessboard();
                System.out.println(isWhiteTurn ? "White's turn" : "Black's turn");
                System.out.print("Enter your move (e.g., e2 to e4): ");
//                System.out.println(getPieceAtPosition("a1"));
                String move = scanner.nextLine();

                if (isValidMove(move)) {
                    makeMove(move);
                    isWhiteTurn = !isWhiteTurn;  // works
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

        }

        private boolean isValidMove(String move) {
            //tim code
            return move.matches("[A-Ha-h][1-8] to [A-Ha-h][1-8]"); //works
        }

        private void makeMove(String move) {
            String[] squares = move.split(" to ");
            String startingSquare = squares[0];
            String endingSquare = squares[1];
            System.out.println("Move: " + move);

        }

        private boolean endingHasPiece() {

            return true;
        }

        private boolean incorrectPieceMove() {
            return false;
        }

        private boolean pieceIsSameColour(String move) {
            String[] squares = move.split(" to ");
            String piece = squares[0];
//            if (Character.isUpperCase(getPieceAtPosition(piece))) {
//            }
            return true;
        }

        public char getPieceAtPosition(String position) {

            int row = Integer.parseInt(position.substring(1, 2));
            int col = position.charAt(0) - 'a';
            System.out.println(row + "  " + col);

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
