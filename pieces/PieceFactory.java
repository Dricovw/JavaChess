package pieces;

public class PieceFactory {
    public static ChessPiece createPawn(char symbol) {return new Pawn(symbol);}
    public static ChessPiece createRook(char symbol) {return new Rook(symbol);}

    public static ChessPiece createKnight(char symbol) {return new Knight(symbol);}
    public static ChessPiece createBishop(char symbol) {return new Bishop(symbol);}
    public static ChessPiece createKing(char symbol) {return new King(symbol);}
    public static ChessPiece createQueen(char symbol) {return new Queen(symbol);}
}
