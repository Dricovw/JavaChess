package chessgame;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Chess Game...");
        // Usage of design patterns
        ChessGame chessGame = ChessGame.getInstance();

        // Create a chessboard
        ChessBoard chessBoard = new ChessBoard();

        // Display the initial chessboard
        System.out.println("Initial Chessboard:");
        chessBoard.displayBoard();

        // Example: Move the piece from (1, 2) to (3, 4)
        chessBoard.movePiece(1, 2, 3, 4);

        // Display the updated chessboard
        System.out.println("Updated Chessboard:");
        chessBoard.displayBoard();
        System.out.println("Chess Game finished successfully.");

    }
}
