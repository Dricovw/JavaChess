package pieces;

public interface Piece {
    boolean isValidMove(int startX, int startY, int endX, int endY);

    char getSymbol();
}
