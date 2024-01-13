// Creational Design Pattern: Abstract Factory Pattern
interface PieceFactory {
    ChessPiece createPiece(String type);
}

class WhitePieceFactory implements PieceFactory {
    @Override
    public ChessPiece createPiece(String type) {
        return new ChessPiece("White " + type);
    }
}

class BlackPieceFactory implements PieceFactory {
    @Override
    public ChessPiece createPiece(String type) {
        return new ChessPiece("Black " + type);
    }
}

// Structural Design Pattern: Adapter Pattern
interface ChessPiece {
    void display(int row, int col);
}

class BasicChessPiece implements ChessPiece {
    private String type;

    public BasicChessPiece(String type) {
        this.type = type;
    }

    @Override
    public void display(int row, int col) {
        System.out.println(type + " at position (" + row + ", " + col + ")");
    }
}

// Structural Design Pattern: Decorator Pattern
abstract class ChessPieceDecorator implements ChessPiece {
    protected ChessPiece decoratedPiece;

    public ChessPieceDecorator(ChessPiece decoratedPiece) {
        this.decoratedPiece = decoratedPiece;
    }

    @Override
    public void display(int row, int col) {
        decoratedPiece.display(row, col);
    }
}

class HighlightedChessPieceDecorator extends ChessPieceDecorator {
    public HighlightedChessPieceDecorator(ChessPiece decoratedPiece) {
        super(decoratedPiece);
    }

    @Override
    public void display(int row, int col) {
        System.out.println("Highlighted " + decoratedPiece + " at position (" + row + ", " + col + ")");
    }
}
