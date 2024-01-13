import java.util.Scanner;
//package chess.game;

import pieces.Piece;
import pieces.PieceFactory;
public class ChessGame {
//        private char[][] chessboard;
private Piece[][] chessboard;

        public ChessGame() {
            // Initialize the chessboard
            chessboard = new Piece[8][8];
            chessboard[1][0] = PieceFactory.createPawn('p');
            chessboard[6][0] = PieceFactory.createPawn('P');

//            chessboard = new char[][] {
//                    {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'},
//                    {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                    {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
//                    {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
//            };
        }

        public void start() {
            displayChessboard();
        }

        private void displayChessboard() {
            System.out.println("  a b c d e f g h");
            System.out.println(" +----------------");
            for (int i = 0; i < 8; i++) {
                System.out.print(8 - i + "| ");
                for (int j = 0; j < 8; j++) {
                    System.out.print(chessboard[i][j] + " ");
                }
                System.out.println("| " + (8 - i));
            }
            System.out.println(" +----------------");
            System.out.println("  a b c d e f g h");
        }
    }
