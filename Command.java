import pieces.ChessPiece;

public abstract class Command {
    protected abstract ChessPiece[][] execute();
}

