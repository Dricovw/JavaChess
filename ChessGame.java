import java.util.Scanner;
import pieces.ChessPiece;

public class ChessGame {
    private ChessGameFacade gameFacade;
    private static ChessPiece[][] chessboard;

    public ChessGame() {
        initializeGame();
    }

    private void initializeGame() {
        this.gameFacade = new GameLogic();
        this.chessboard = gameFacade.getChessboard();  // Initialize the chessboard
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayChessboard();
            System.out.println(gameFacade.getCurrentTurn() + "'s turn");
            System.out.println();
            System.out.print("Enter your move (e.g., e2 to e4): ");

            try {
                gameFacade.makeMove(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void displayChessboard() {
        System.out.println("   a b c d e f g h");
        System.out.println(" +----------------");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = chessboard[i][j];
                System.out.print(piece != null ? piece.getSymbol() + " " : "  ");  // Check for null
            }
            System.out.println("| " + (i + 1));
        }
        System.out.println(" +----------------");
        System.out.println("   a b c d e f g h");
    }

    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.start();
    }
}
