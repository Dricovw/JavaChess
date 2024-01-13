package pieces;

public class King implements Piece {
    private char symbol;

    public King(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // King's move: One square in any direction
        int xDiff = Math.abs(endX - startX);
        int yDiff = Math.abs(endY - startY);
        return xDiff <= 1 && yDiff <= 1;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
