package pieces;

public class WhitePieceFactory implements PieceFactory {

    public static ChessPiece createPawn(char symbol) {
        return new Pawn(Character.toLowerCase(symbol));
    }

    public static ChessPiece createRook(char symbol) {
        return new Rook(Character.toLowerCase(symbol));
    }

    public static ChessPiece createKnight(char symbol) {
        return new Knight(Character.toLowerCase(symbol));
    }

    public static ChessPiece createBishop(char symbol) {
        return new Bishop(Character.toLowerCase(symbol));
    }

    public static ChessPiece createKing(char symbol) {
        return new King(Character.toLowerCase(symbol));
    }

    public static ChessPiece createQueen(char symbol) {
        return new Queen(Character.toLowerCase(symbol));
    }
}
