// ChessPiece.java
public interface ChessPiece {
    void move();
}

// Pawn.java
public class Pawn implements ChessPiece {
    @Override
    public void move() {
        // Implementation for pawn's movement
    }
}

// Rook.java
public class Rook implements ChessPiece {
    @Override
    public void move() {
        // Implementation for rook's movement
    }
}

// ... (similar classes for other chess pieces)