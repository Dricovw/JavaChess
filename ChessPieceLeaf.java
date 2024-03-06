import pieces.ChessPiece;

public class ChessPieceLeaf implements ChessComponent {
    private ChessPiece piece;

    public ChessPieceLeaf(ChessPiece piece) {
        this.piece = piece;
    }

    @Override
    public void display() {
        System.out.print(piece != null ? piece.getSymbol() + " " : "  ");
    }

    @Override
    public char getSymbol() {
        if (piece == null) {
            return ' ';
        } else {
            return piece.getSymbol();
        }
//        return piece != null ? piece.getSymbol() : ' ';
    }
}