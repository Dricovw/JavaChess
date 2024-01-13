// Bishop.java
package pieces;

public class Bishop extends ChessPiece {
    public Bishop(char symbol) {
        super(symbol);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Implement specific bishop movement rules
        // For simplicity, let's assume bishops move diagonally any number of squares
        int xDiff = Math.abs(endX - startX);
        int yDiff = Math.abs(endY - startY);
        return xDiff == yDiff;
    }
}
