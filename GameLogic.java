import pieces.ChessPiece;
import pieces.PieceFactory;

public class GameLogic implements ChessGameFacade {
    private ChessPiece[][] chessboard;
    private boolean isWhiteTurn;

    public GameLogic() {
        initializeChessboard();
        isWhiteTurn = true;
    }

    public ChessPiece[][] getChessboard() {
        return chessboard;
    }


    private void initializeChessboard() {
        chessboard = new ChessPiece[8][8];;
        chessboard[7][7] = PieceFactory.createRook('R');
        chessboard[7][0] = PieceFactory.createRook('R');
        chessboard[0][7] = PieceFactory.createRook('r');
        chessboard[0][0] = PieceFactory.createRook('r');
        chessboard[7][5] = PieceFactory.createBishop('B');
        chessboard[7][2] = PieceFactory.createBishop('B');
        chessboard[0][5] = PieceFactory.createBishop('b');
        chessboard[0][2] = PieceFactory.createBishop('b');
        chessboard[7][6] = PieceFactory.createKnight('N');
        chessboard[7][1] = PieceFactory.createKnight('N');
        chessboard[0][6] = PieceFactory.createKnight('n');
        chessboard[0][1] = PieceFactory.createKnight('n');
        chessboard[7][4] = PieceFactory.createQueen('Q');
        chessboard[0][3] = PieceFactory.createQueen('q');
        chessboard[7][3] = PieceFactory.createKing('K');
        chessboard[0][4] = PieceFactory.createKing('k');
        for (int i = 0; i < 8; i++) {
            chessboard[1][i] = PieceFactory.createPawn('p');
        }
        for (int i = 0; i < 8; i++) {
            chessboard[6][i] = PieceFactory.createPawn('P');
        }
    }

    @Override
    public void makeMove(String move) {
        String[] squares = move.split(" to ");
        int startX = positionToNumber(squares[0], "row");
        int startY = positionToNumber(squares[0], "column");
        int endX = positionToNumber(squares[1], "row");
        int endY = positionToNumber(squares[1], "column");

        if (PieceMove.isValidMove(move, this)) {
            PieceMove.makeMove(move, this);
            isWhiteTurn = !isWhiteTurn;
        } else {
            setError("Invalid move. Try again.");
            throw new IllegalArgumentException("Invalid move: " + move);
        }
    }

    @Override
    public String getCurrentTurn() {
        return isWhiteTurn ? "White" : "Black";
    }

    @Override
    public void setChessboardValue(int row, int column, ChessPiece value) {
        chessboard[row][column] = value;
    }


    public char positionToPiece(String position) {
        int row = Integer.parseInt(position.substring(1, 2)) - 1;
        int col = position.charAt(0) - 'a';

        if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
            if (chessboard[row][col] == null) {
                return 'E';
            } else {

                return chessboard[row][col].getSymbol();
            }
        } else {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    @Override
    public int positionToNumber(String position, String rowOrcolumn) {
        char file = position.charAt(0);
        int rank = Character.getNumericValue(position.charAt(1));

        if (file >= 'a' && file <= 'h' && rank >= 1 && rank <= 8) {
            int col = file - 'a';
            int row = rank - 1;
            int[] number = {row, col};
            if (rowOrcolumn.equals("row")) {
                return number[0];
            } else {
                return number[1];
            }
        } else {
            String error = "invalid position";
        }
        return -1;
    }

    @Override
    public void setError(String error) {
        // Implement the logic to set the error message
    }
}
