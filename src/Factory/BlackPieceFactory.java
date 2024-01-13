// BlackPieceFactory.java
public class BlackPieceFactory implements PieceFactory {
    @Override
    public ChessPiece createPiece(String type) {
        switch (type) {
            case "Pawn":
                return new BlackPawn();
            case "Rook":
                return new BlackRook();
            // Add cases for other piece types as needed
            default:
                throw new IllegalArgumentException("Invalid piece type: " + type);
        }
    }
}

// BlackPawn.java
public class BlackPawn implements ChessPiece {
    @Override
    public void move() {
        // Implementation for black pawn's movement
    }
}

// BlackRook.java
public class BlackRook implements ChessPiece {
    @Override
    public void move() {
        // Implementation for black rook's movement
    }
}
