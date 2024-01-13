package pieces;

public class PieceFactory {
    public static Piece createPawn(char symbol) {
        return new Pawn();
    }
}
