public class Main {
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
