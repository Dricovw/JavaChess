package pieces;

public class Queen implements Piece {
    private char symbol;

    public Queen(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Queen's move: Diagonal or straight movement
        int xDiff = Math.abs(endX - startX);
        int yDiff = Math.abs(endY - startY);
        return startX == endX || startY == endY || xDiff == yDiff;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
