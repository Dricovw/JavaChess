package pieces;

public class BlackPieceFactory implements PieceFactory {

    public static ChessPiece createPawn(char symbol) {
        return new Pawn(Character.toUpperCase(symbol));
    }

    public static ChessPiece createRook(char symbol) {
        return new Rook(Character.toUpperCase(symbol));
    }

    public static ChessPiece createKnight(char symbol) {
        return new Knight(Character.toUpperCase(symbol));
    }

    public static ChessPiece createBishop(char symbol) {
        return new Bishop(Character.toUpperCase(symbol));
    }

    public static ChessPiece createKing(char symbol) {
        return new King(Character.toUpperCase(symbol));
    }

    public static ChessPiece createQueen(char symbol) {
        return new Queen(Character.toUpperCase(symbol));
    }
}
