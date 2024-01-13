public class pawn implements piece {
    private char symbol;

    public void Pawn(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY) {
        // Implement pawn movement rules
        // For simplicity, let's assume pawns can only move forward one square and capture diagonally
        return (endY == startY) && (
                (symbol == 'p' && endX == startX + 1) ||
                        (symbol == 'P' && endX == startX - 1)
        );
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
