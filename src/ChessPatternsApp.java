public class ChessPatternsApp {
    public static void main(String[] args) {
        // Usage of design patterns
        ChessGame chessGame = ChessGame.getInstance();

        // Creational design pattern: Abstract Factory
        PieceFactory whitePieceFactory = new WhitePieceFactory();
        PieceFactory blackPieceFactory = new BlackPieceFactory();

        ChessPiece whitePawn = whitePieceFactory.createPiece("Pawn");
        ChessPiece blackKing = blackPieceFactory.createPiece("King");

        // Structural design pattern: Adapter
        chessGame.addPiece(new BasicChessPiece("White Queen"));
        chessGame.addPiece(new BasicChessPiece("Black Knight"));

        // Structural design pattern: Decorator
        ChessPiece highlightedPawn = new HighlightedChessPieceDecorator(whitePawn);
        highlightedPawn.display(2, 3);

        // Behavioral design pattern: Observer
        ChessObserver moveLogger = new MoveLogger();
        chessGame.addObserver(moveLogger);

        // Behavioral design pattern: Command
        ChessMoveCommand moveCommand = new MovePieceCommand(chessGame, 1, 2, 3, 4);
        moveCommand.execute();

        // Display the updated game state
        // Additional game logic and interactions...
    }
}



// Behavioral Design Pattern: Observer Pattern
interface ChessObserver {
    void update();
}

class MoveLogger implements ChessObserver {
    @Override
    public void update() {
        System.out.println("Move Log: Chess game state updated");
    }
}

// Behavioral Design Pattern: Command Pattern
interface ChessMoveCommand {
    void execute();
}

class MovePieceCommand implements ChessMoveCommand {
    private ChessGame chessGame;
    private int fromRow, fromCol, toRow, toCol;

    public MovePieceCommand(ChessGame chessGame, int fromRow, int fromCol, int toRow, int toCol) {
        this.chessGame = chessGame;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    @Override
    public void execute() {
        chessGame.movePiece(fromRow, fromCol, toRow, toCol);
    }
}
