// Queen.java
package pieces;

public class Queen extends ChessPiece {
    public Queen(char symbol) {
        super(symbol);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Implement specific queen movement rules
        // For simplicity, let's assume queens can move horizontally, vertically, or diagonally any number of squares
        int xDiff = Math.abs(endX - startX);
        int yDiff = Math.abs(endY - startY);
        return startX == endX || startY == endY || xDiff == yDiff;
    }
}
