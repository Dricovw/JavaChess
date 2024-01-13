// ChessPieceFactory.java
public interface ChessPieceFactory {
    ChessPiece createPiece();
}

// PawnFactory.java
public class PawnFactory implements ChessPieceFactory {
    @Override
    public ChessPiece createPiece() {
        return new Pawn();
    }
}

// RookFactory.java
public class RookFactory implements ChessPieceFactory {
    @Override
    public ChessPiece createPiece() {
        return new Rook();
    }
}