// Rook.java
package pieces;

public class Rook extends ChessPiece {
    public Rook(char symbol) {
        super(symbol);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Implement specific rook movement rules
        // For simplicity, let's assume rooks can move horizontally or vertically any number of squares
        return startX == endX || startY == endY;
    }
}
