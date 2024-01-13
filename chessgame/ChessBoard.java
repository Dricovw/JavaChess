package chessgame;

import java.util.Arrays;

public class ChessBoard {
    private static final int BOARD_SIZE = 8;
    private ChessPiece[][] board;

    public ChessBoard() {
        // Initialize the chessboard
        board = new ChessPiece[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        // Set up the initial chessboard with pieces
        // For simplicity, let's add a few pieces for testing
        // In a real game, you'd set up the standard starting position.
        PieceFactory whitePieceFactory = new WhitePieceFactory();
        PieceFactory blackPieceFactory = new BlackPieceFactory();

        // Example: Place a white pawn at (1, 2) and a black king at (7, 4)
        placePiece(whitePieceFactory.createPiece("Pawn"), 1, 2);
        placePiece(blackPieceFactory.createPiece("King"), 7, 4);
    }

    public void displayBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != null) {
                    board[i][j].display(i, j);
                } else {
                    System.out.print("[ ]"); // Empty square
                }
            }
            System.out.println(); // Move to the next row
        }
    }

    public void placePiece(ChessPiece piece, int row, int col) {
        if (isValidPosition(row, col)) {
            board[row][col] = piece;
        } else {
            System.out.println("Invalid position for placing the piece.");
        }
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        if (isValidPosition(fromRow, fromCol) && isValidPosition(toRow, toCol)) {
            // Check if there's a piece at the source position
            ChessPiece pieceToMove = board[fromRow][fromCol];
            if (pieceToMove != null) {
                // Move the piece to the destination
                board[toRow][toCol] = pieceToMove;
                board[fromRow][fromCol] = null;
                System.out.println("Piece moved successfully.");
            } else {
                System.out.println("No piece to move at the source position.");
            }
        } else {
            System.out.println("Invalid positions for moving the piece.");
        }
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }
}
