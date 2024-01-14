import pieces.ChessPiece;

public interface ChessGameFacade {
    void makeMove(String move);
    String getCurrentTurn();
    char positionToPiece(String position);
    int positionToNumber(String position, String rowOrColumn);
    ChessPiece[][] getChessboard();
    void setError(String error);
    void setChessboardValue(int row, int column, ChessPiece value);
}
