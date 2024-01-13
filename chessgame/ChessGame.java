import java.util.ArrayList;
import java.util.List;
package chessgame;
// Creational Design Pattern: Singleton Pattern
class ChessGame {
    private static ChessGame instance;
    private List<ChessPiece> pieces;
    private List<ChessObserver> observers;

    private ChessGame() {
        this.pieces = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public static ChessGame getInstance() {
        if (instance == null) {
            instance = new ChessGame();
        }
        return instance;
    }

    public void addObserver(ChessObserver observer) {
        observers.add(observer);
    }

    public void addPiece(ChessPiece piece) {
        pieces.add(piece);
        notifyObservers();
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        // Move the chess piece on the board (omitted for simplicity)
        notifyObservers();
    }

    private void notifyObservers() {
        for (ChessObserver observer : observers) {
            observer.update();
        }
    }
}
