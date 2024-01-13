// King.java
package pieces;

public class King extends ChessPiece {
    public King(char symbol) {
        super(symbol);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Implement specific king movement rules
        // For simplicity, let's assume kings can move one square in any direction
        int xDiff = Math.abs(endX - startX);
        int yDiff = Math.abs(endY - startY);
        return xDiff <= 1 && yDiff <= 1;
    }
}
