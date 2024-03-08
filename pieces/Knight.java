// Knight.java
package pieces;

public class Knight extends ChessPiece {
    public Knight(char symbol) {
        super(symbol);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {

        int xDiff = Math.abs(endX - startX);
        int yDiff = Math.abs(endY - startY);
        return (xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2);
    }
}
