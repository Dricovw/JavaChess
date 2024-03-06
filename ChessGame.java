import pieces.King;

import java.util.Scanner;

public class ChessGame {
    private ChessGameFacade gameFacade;

    private String winner;

    private ChessboardManager chessboardManager;
    private static ChessComponent[][] chessboard;

    public ChessGame() {
        initializeGame();
        StartGameCommand startGameCommand = new StartGameCommand();
        startGameCommand.execute();
        this.chessboardManager = ChessboardManager.getInstance();
    }

    private void initializeGame() {
        this.gameFacade = new GameLogic();
        this.chessboard = gameFacade.getChessboard();

    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!IsGameOver(chessboard)) {
                EndGameCommand endGameCommand = new EndGameCommand(winner);
                endGameCommand.execute();
                break;
            }

            displayChessboard();  // Use display method
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
                ChessComponent square = chessboard[i][j];
                if (square != null) {
                    square.display();  // Assuming ChessComponent has a display method
                } else {
                    System.out.print("  ");  // Placeholder for empty square
                }
            }
            System.out.println("| " + (i + 1));
        }
        System.out.println(" +----------------");
        System.out.println("   a b c d e f g h");

    }

    public boolean IsGameOver(ChessComponent[][] chessboard) {
        boolean whiteKingFound = false;
        boolean blackKingFound = false;


        for (ChessComponent[] row : chessboard) {
            for (ChessComponent piece : row) {
                if (piece != null) {
                    if (piece.getSymbol() == 'k') {
                        whiteKingFound = true;
                    } else if (piece.getSymbol() == 'K') {
                        blackKingFound = true;
                    }

                }
            }
        }

            if (whiteKingFound != true) {
                winner = "black";
            } else if (blackKingFound != true) {
                winner = "white";
            }
            return whiteKingFound && blackKingFound;
        }

    }


