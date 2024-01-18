import java.util.ArrayList;
import java.util.List;

public class ChessSquareComposite implements ChessComponent {
    private List<ChessComponent> components;

    public ChessSquareComposite() {
        this.components = new ArrayList<>();
    }

    public void addComponent(ChessComponent component) {
        components.add(component);
    }

    @Override
    public void display() {
        for (ChessComponent component : components) {
            component.display();
        }
    }

    @Override
    public char getSymbol() {
        return 0;
    }
}