import pieces.ChessPiece;

public class MakeMoveCommand extends Command {
    private String move;
    private ChessPiece[][] chessboard;

    public MakeMoveCommand(String move, ChessPiece[][] chessboard) {
        this.move = move;
        this.chessboard = chessboard;
    }

    @Override
    public ChessPiece[][] execute() {
        // Your logic here
        if (PieceMove.isValidMove(move)) {
            String[] squares = move.split(" to ");
            int pieceStartRow = ChessGame.positionToNumber(squares[0], "row");
            int pieceStartColumn = ChessGame.positionToNumber(squares[0], "column");
            int pieceEndRow = ChessGame.positionToNumber(squares[1], "row");
            int pieceEndColumn = ChessGame.positionToNumber(squares[1], "column");

            chessboard[pieceEndRow][pieceEndColumn] = PieceMove.symbolToPiece("" + ChessGame.positionToPiece(squares[0]));
            chessboard[pieceStartRow][pieceStartColumn] = null;
            return chessboard;
        } else {
            throw new IllegalArgumentException("Invalid move");
        }
    }
}
