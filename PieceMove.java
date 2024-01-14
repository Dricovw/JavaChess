import pieces.ChessPiece;
import pieces.Pawn;
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
           throw new IllegalArgumentException("same colour");
       }
            return true;
        }
        throw new IllegalArgumentException("Invalid move:");
    }

    public static ChessPiece[][] makeMove(String move, ChessPiece[][] chessboard) {
        String[] squares = move.split(" to ");
        int pieceStartRow = ChessGame.positionToNumber(squares[0], "row");
        int pieceStartColumn = ChessGame.positionToNumber(squares[0], "column");
        int pieceEndRow = ChessGame.positionToNumber(squares[1], "row");
        int pieceEndColumn = ChessGame.positionToNumber(squares[1], "column");

        chessboard[pieceEndRow][pieceEndColumn] = symbolToPiece("" + ChessGame.positionToPiece(squares[0]));
        chessboard[pieceStartRow][pieceStartColumn] = null;
        return chessboard;
    }

    private static ChessPiece symbolToPiece(String position) {
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
    private static boolean pieceIsSameColour(String move) {
        String[] squares = move.split(" to ");
        return Character.isUpperCase(ChessGame.positionToPiece(squares[0])) == Character.isUpperCase(ChessGame.positionToPiece(squares[1])) || Character.isLowerCase(ChessGame.positionToPiece(squares[0])) == Character.isLowerCase(ChessGame.positionToPiece(squares[1])) ;
    }
}
