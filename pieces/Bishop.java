package pieces;

public class Bishop implements Piece {
    private char symbol;

    public Bishop(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Bishop's move: Diagonal movement
        int xDiff = Math.abs(endX - startX);
        int yDiff = Math.abs(endY - startY);
        return xDiff == yDiff;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
