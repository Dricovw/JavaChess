public class PieceMove {

    public static boolean isValidMove(String move) {
        // Your validation logic using the chessboard parameter
        return move.matches("[A-Ha-h][1-8] to [A-Ha-h][1-8]");
    }

    public static void makeMove(String move) {
        // Your move logic using the chessboard parameter
        String[] squares = move.split(" to ");
        String startingSquare = squares[0];
        String endingSquare = squares[1];
        System.out.println("Move: " + move);
    }

    private boolean endingHasPiece() {

        return true;
    }

    private boolean pieceIsSameColour(String move) {
        String[] squares = move.split(" to ");
        String oldpiece = squares[0];
        String newpiece = squares[1];
        if (Character.isUpperCase(ChessGame.getPieceAtPosition(oldpiece)) == Character.isUpperCase(ChessGame.getPieceAtPosition(newpiece))) {
            System.out.println("same piece");
            return false;
            }
        return true;
    }


}


