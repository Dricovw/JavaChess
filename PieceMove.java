import pieces.ChessPiece;
import pieces.PieceFactory;

public class PieceMove {

    public static boolean isValidMove(String move, ChessGameFacade chessGame) {
        String[] squares = move.split(" to ");

        ChessPiece piece = symbolToPiece("" + GameLogic.positionToPiece(squares[0]));

        if (piece != null && piece.isValidMove(
                chessGame.positionToNumber(squares[0], "row"),
                chessGame.positionToNumber(squares[0], "column"),
                chessGame.positionToNumber(squares[1], "row"),
                chessGame.positionToNumber(squares[1], "column"))) {

            if (pieceIsSameColour(move, chessGame)) {
                chessGame.setError("same colour");
            } else {
                return true;
            }
        }

        chessGame.setError("invalid move");
        return false;
    }


    public static ChessComponent[][] makeMove(String move, ChessGameFacade chessGame) {
        String[] squares = move.split(" to ");
        int pieceStartRow = chessGame.positionToNumber(squares[0], "row");
        int pieceStartColumn = chessGame.positionToNumber(squares[0], "column");
        int pieceEndRow = chessGame.positionToNumber(squares[1], "row");
        int pieceEndColumn = chessGame.positionToNumber(squares[1], "column");

        chessGame.setChessboardValue(pieceEndRow, pieceEndColumn, symbolToPiece("" + GameLogic.positionToPiece(squares[0])));
        chessGame.setChessboardValue(pieceStartRow, pieceStartColumn, null);
        return chessGame.getChessboard();
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

    private static boolean pieceIsSameColour(String move, ChessGameFacade chessGame) {
        String[] squares = move.split(" to ");
        if (GameLogic.positionToPiece(squares[1]) == 'E') {
            return false;
        } else {
            return Character.isUpperCase(GameLogic.positionToPiece(squares[0])) == Character.isUpperCase(GameLogic.positionToPiece(squares[1])) ||
                    Character.isLowerCase(GameLogic.positionToPiece(squares[0])) == Character.isLowerCase(GameLogic.positionToPiece(squares[1]));
        }
    }
}
