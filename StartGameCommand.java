public class StartGameCommand extends Command {
    @Override
    public String execute() {
        System.out.println("Game starting!");
        return null;
    }

    @Override
    public String execute(boolean winner) {
        return null;
    }
}
