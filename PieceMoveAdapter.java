import pieces.ChessPiece;
import pieces.Piece;

// PieceMoveAdapter.java
public abstract class PieceMoveAdapter implements Piece {


    public PieceMoveAdapter() {

    }

    public static boolean checkValidMove(int row, int column, int endrow, int endcolumn) {
        ChessPiece piece = PieceMove.symbolToPiece("" + GameLogic.positionToPiece((char) ('a' + column) + "" + (row + 1)));
        return piece.isValidMove(row, column, endrow, endcolumn);

    }


    @Override
    public char getSymbol() {
        return 0;
    }


}
