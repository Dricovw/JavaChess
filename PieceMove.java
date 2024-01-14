import pieces.ChessPiece;
import pieces.PieceFactory;

public class PieceMove {

    public static boolean isValidMove(String move) {
        String[] squares = move.split(" to ");
        ChessPiece piece = symbolToPiece("" + ChessGame.positionToPiece(squares[0]));
        if (piece != null && piece.isValidMove(
                ChessGame.positionToNumber(squares[0], "row"),
                ChessGame.positionToNumber(squares[0], "column"),
                ChessGame.positionToNumber(squares[1], "row"),
                ChessGame.positionToNumber(squares[1], "column"))) {

       if (pieceIsSameColour(move)) {
           ChessGame.error = "same colour";
       } else {
           return true;
       }
        }
       ChessGame.error = "invalid move";
        return false;
    }

    public static ChessPiece[][] makeMove(String move, ChessPiece[][] chessboard) {
        try {
            Command moveCommand = new MakeMoveCommand(move, chessboard);
            return ((MakeMoveCommand) moveCommand).execute();
        } catch (IllegalArgumentException e) {
            // Handle the exception (print, log, etc.)
            ChessGame.error = e.getMessage();
            return chessboard;  // or return null, depending on your design
        }
    }

    public class StartGameCommand extends Command {
        private ChessPiece[][] chessboard;

        public StartGameCommand(ChessPiece[][] chessboard) {
            this.chessboard = chessboard;
        }

        @Override
        public ChessPiece[][] execute() {
            // Logic to start the chess game, initialize the chessboard, etc.
            // ...
            return new ChessPiece[0][0];
        }
    }

    public class EndGameCommand extends Command {
        private ChessPiece[][] chessboard;

        public EndGameCommand(ChessPiece[][] chessboard) {
            this.chessboard = chessboard;
        }

        @Override
        public ChessPiece[][] execute() {
            // Logic to end the chess game, determine the winner, cleanup, etc.
            // ...
            return new ChessPiece[0][0];
        }
    }


    static ChessPiece symbolToPiece(String position) {
        switch (position.charAt(0)) {
            case 'p':
                return PieceFactory.createPawn('p');
            case 'P':
                return PieceFactory.createPawn('P');
            case 'r':
                return PieceFactory.createRook('r');
            case 'R':
                return PieceFactory.createRook('R');
            case 'b':
                return PieceFactory.createBishop('b');
            case 'B':
                return PieceFactory.createBishop('B');
            case 'q':
                return PieceFactory.createQueen('q');
            case 'Q':
                return PieceFactory.createQueen('Q');
            case 'n':
                return PieceFactory.createKnight('n');
            case 'N':
                return PieceFactory.createKnight('N');
            case 'k':
                return PieceFactory.createKing('k');
            case 'K':
                return PieceFactory.createKing('K');
            default:
                System.out.println("Invalid move. Try again.");
                return null;
        }
    }
    public static boolean pieceIsSameColour(String move) {
        String[] squares = move.split(" to ");
        if (ChessGame.positionToPiece(squares[1]) == 'E') {
            return false;
        } else {
        return Character.isUpperCase(ChessGame.positionToPiece(squares[0])) == Character.isUpperCase(ChessGame.positionToPiece(squares[1])) || Character.isLowerCase(ChessGame.positionToPiece(squares[0])) == Character.isLowerCase(ChessGame.positionToPiece(squares[1])) ;
    }}
}
