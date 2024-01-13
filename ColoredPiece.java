//// ColoredPiece.java
//public class ColoredPiece implements Piece {
//    private Piece originalPiece;
//    private String color;
//
//    // ANSI escape codes for text colors
//    private static final String ANSI_RESET = "\u001B[0m";
//    private static final String ANSI_BLACK = "\u001B[30m";
//    private static final String ANSI_WHITE = "\u001B[37m";
//
//    public ColoredPiece(Piece originalPiece, String color) {
//        this.originalPiece = originalPiece;
//        this.color = color;
//    }
//
//    @Override
//    public void move() {
//        originalPiece.move();
//
//        // Apply color based on the provided color parameter
//        switch (color.toLowerCase()) {
//            case "black":
//                System.out.print(ANSI_BLACK);
//                break;
//            case "white":
//                System.out.print(ANSI_WHITE);
//                break;
//            default:
//                // Default to no color
//                break;
//        }
//
//        System.out.println("Color: " + color + ANSI_RESET);
//    }
//}
