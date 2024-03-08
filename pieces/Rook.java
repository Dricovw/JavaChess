// Rook.java
package pieces;

public class Rook extends ChessPiece {
    public Rook(char symbol) {
        super(symbol);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {

        return startX == endX || startY == endY;
    }
}
