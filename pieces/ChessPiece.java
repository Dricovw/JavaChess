// ChessPiece.java
package pieces;


public class ChessPiece implements Piece {
    private char symbol;

    public ChessPiece(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Default implementation for generic chess piece movement

        return true;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
