import pieces.ChessPiece;

public class ChessboardManager {
    // Step 1: Private static instance
    private static ChessboardManager instance;

    // Step 2: Private constructor to prevent instantiation outside the class
    private ChessboardManager() {
        // Initialization code here
    }

    // Step 3: Public method to get the instance
    public static ChessboardManager getInstance() {
        // Step 4: Lazy initialization - create the instance if it doesn't exist
        if (instance == null) {
            instance = new ChessboardManager();
        }
        return instance;
    }

    public ChessComponent getChessboardComponent(int row, int col, ChessPiece[][] chessboard) {

        if (row >= 0 && row < 8 && col >= 0 && col < 8) {

            return (ChessComponent) chessboard[row][col];
        } else {
            throw new IllegalArgumentException("Invalid row or column");
        }
    }

}
