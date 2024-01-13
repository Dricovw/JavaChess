package pieces;

public class PieceFactory {
    public static Piece createPawn(char symbol) {return new Pawn(symbol);}
    public static Piece createRook(char symbol) {return new Rook(symbol);}

    public static void main(String[] args) {
        Piece pawn = PieceFactory.createPawn('p');
        Piece rook = PieceFactory.createRook('R');
    }
}
