public interface piece {
    boolean isValidMove(int startX, int startY, int endX, int endY);
    char getSymbol();
}
