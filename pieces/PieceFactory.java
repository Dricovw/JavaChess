package pieces;

public class PieceFactory {
    public static Piece createPawn(char symbol) {return new Pawn(symbol);}
    public static Piece createRook(char symbol) {return new Rook(symbol);}

    public static Piece createKnight(char symbol) {return new Knight(symbol);}
    public static Piece createBishop(char symbol) {return new Bishop(symbol);}
    public static Piece createKing(char symbol) {return new King(symbol);}
    public static Piece createQueen(char symbol) {return new Queen(symbol);}
}
