// Pawn.java
package pieces;

public class Pawn extends ChessPiece {
    public Pawn(char symbol) {
        super(symbol);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {

        return (endY == startY) && (
                (getSymbol() == 'p' && endX == startX + 1) ||
                        (getSymbol() == 'P' && endX == startX - 1)
        );
    }
}
