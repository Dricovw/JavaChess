// Pawn.java
package pieces;

public class Pawn extends ChessPiece {
    public Pawn(char symbol) {
        super(symbol);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Implement specific pawn movement rules
        // For simplicity, let's assume pawns can only move forward one square and capture diagonally
        return (endY == startY) && (
                (getSymbol() == 'p' && endX == startX + 1) ||
                        (getSymbol() == 'P' && endX == startX - 1)
        );
    }
}
