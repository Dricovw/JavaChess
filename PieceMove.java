public class PieceMove {

    public static boolean isValidMove(String move) {
        // Your validation logic using the chessboard parameter
        return move.matches("[A-Ha-h][1-8] to [A-Ha-h][1-8]");
    }

    public static void makeMove(String move) {
        String[] squares = move.split(" to ");
        String startPos = squares[0];
        String endPos = squares[1];
        String pieceStart =  ChessGame.positionToNumber(squares[0]);
        String pieceEnd = ChessGame.positionToNumber(squares[1]);
        //chessboard[][]
        System.out.println("Move: " + pieceStart + endPos );
    }

    private boolean endingHasPiece() {

        return true;
    }

    private boolean pieceIsSameColour(String move) {
        String[] squares = move.split(" to ");
        String oldpiece = squares[0];
        String newpiece = squares[1];
        if (Character.isUpperCase(ChessGame.positionToPiece(ChessGame.positionToNumber(oldpiece))) == Character.isUpperCase(ChessGame.positionToPiece(ChessGame.positionToNumber(newpiece)))) {
            System.out.println("same piece");
            return false;
            }
        return true;
    }


}


