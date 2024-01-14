import pieces.ChessPiece;
import pieces.Pawn;
import pieces.PieceFactory;
import pieces.Pawn;

public class PieceMove {

    public static boolean isValidMove(String move) {
        String[] squares = move.split(" to ");
        Pawn pawn = new Pawn('p');
            if (pawn.isValidMove(
                    ChessGame.positionToNumber(squares[0], "row"),
                    ChessGame.positionToNumber(squares[0], "column"),
                    ChessGame.positionToNumber(squares[1], "row") ,
                    ChessGame.positionToNumber(squares[1], "column")
            )){
//                if (!pieceIsSameColour(move)) {
//                    return false;
//                }
                return move.matches("[A-Ha-h][1-8] to [A-Ha-h][1-8]");
            }
        throw new IllegalArgumentException("Invalid move: ");
    }

    public static ChessPiece[][] makeMove(String move, ChessPiece[][] chessboard) {
        String[] squares = move.split(" to ");
        int pieceStartRow = ChessGame.positionToNumber(squares[0], "row");
        int pieceStartColumn = ChessGame.positionToNumber(squares[0], "column");
        int pieceEndRow = ChessGame.positionToNumber(squares[1], "row");
        int pieceEndColumn = ChessGame.positionToNumber(squares[1], "column");

        chessboard[pieceEndRow][pieceEndColumn] = whatPieceMoves(squares[0]);
        chessboard[pieceStartRow][pieceStartColumn] = null;
        return chessboard;
    }

    private static ChessPiece whatPieceMoves(String position) {
        char oldPiece = ChessGame.positionToPiece(position);
        if (oldPiece == 'p') {
            return PieceFactory.createPawn('p');
        } else if (oldPiece == 'P') {
            return PieceFactory.createPawn('P');
        } else if (oldPiece == 'r') {
            return PieceFactory.createRook('r');
        } else if (oldPiece == 'R') {
            return PieceFactory.createRook('R');
        } else if (oldPiece == 'b') {
            return PieceFactory.createBishop('b');
        } else if (oldPiece == 'B') {
            return PieceFactory.createBishop('B');
        } else if (oldPiece == 'q') {
            return PieceFactory.createQueen('q');
        } else if (oldPiece == 'Q') {
            return PieceFactory.createQueen('q');
        } else if (oldPiece == 'n') {
            return PieceFactory.createKnight('n');
        } else if (oldPiece == 'N') {
            return PieceFactory.createKnight('N');
        } else if (oldPiece == 'k') {
            return PieceFactory.createKing('k');
        } else if (oldPiece == 'K') {
            return PieceFactory.createKing('K');
        } else {
            System.out.println("Invalid move. Try again.");
        }
        return PieceFactory.createPawn('e');
    }

    private static boolean piecesExist(String move) {
        String[] squares = move.split(" to ");
        String startpiece = "" + ChessGame.positionToPiece(squares[0]);
        String endpiece = String.valueOf(ChessGame.positionToPiece(squares[1]));
        if (startpiece == null) {
            return false;
        }
        if (endpiece == null) {
            return false;
        }
        return true;
    }


    private static boolean pieceIsSameColour(String move) {
        String[] squares = move.split(" to ");
        if (!Character.isUpperCase(ChessGame.positionToPiece(squares[0])) == Character.isUpperCase(ChessGame.positionToPiece(squares[1]))) {
            return false;
        }
        return false;
    }


}


