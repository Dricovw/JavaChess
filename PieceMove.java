import pieces.*;

public class PieceMove {

    public static boolean isValidMove(String move, ChessGameFacade chessGame) {
        String[] squares = move.split(" to ");

        ChessPiece piece = symbolToPiece("" + GameLogic.positionToPiece(squares[0]));

        System.out.println(piece.getSymbol());

        if (piece != null && PieceMoveAdapter.checkValidMove(
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

        ChessPiece decoratedPiece = symbolToPiece("" + GameLogic.positionToPiece(squares[0]));

//        System.out.println(decoratedPiece);

        chessGame.setChessboardValue(pieceEndRow, pieceEndColumn, decoratedPiece);
        chessGame.setChessboardValue(pieceStartRow, pieceStartColumn, null);
        return chessGame.getChessboard();
    }

    static ChessPiece symbolToPiece(String position) {
        char symbol = position.charAt(0);

        switch (symbol) {
            case 'p':
                return WhitePieceFactory.createPawn(symbol);
            case 'r':
                return WhitePieceFactory.createRook(symbol);
            case 'n':
                return WhitePieceFactory.createKnight(symbol);
            case 'b':
                return WhitePieceFactory.createBishop(symbol);
            case 'q':
                return WhitePieceFactory.createQueen(symbol);
            case 'k':
                return WhitePieceFactory.createKing(symbol);
            case 'P':
                return BlackPieceFactory.createPawn(symbol);
            case 'R':
                return BlackPieceFactory.createRook(symbol);
            case 'N':
                return BlackPieceFactory.createKnight(symbol);
            case 'B':
                return BlackPieceFactory.createBishop(symbol);
            case 'Q':
                return BlackPieceFactory.createQueen(symbol);
            case 'K':
                return BlackPieceFactory.createKing(symbol);
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
