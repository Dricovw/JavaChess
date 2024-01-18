import pieces.ChessPiece;

public interface ChessGameFacade {
    void makeMove(String move);
    String getCurrentTurn();

    int positionToNumber(String position, String rowOrColumn);
    ChessComponent[][] getChessboard();
    void setError(String error);
    void setChessboardValue(int row, int column, ChessPiece value);
}
