package pieces;

public class Knight implements Piece {
    private char symbol;

    public Knight(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Knight's move: 2 squares in one direction and 1 square in another
        int xDiff = Math.abs(endX - startX);
        int yDiff = Math.abs(endY - startY);
        return (xDiff == 2 && yDiff == 1) || (xDiff == 1 && yDiff == 2);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
