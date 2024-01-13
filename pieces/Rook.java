package pieces;

public class Rook implements Piece {
    private char symbol;

    public Rook(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        return startX == endX || startY == endY;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
