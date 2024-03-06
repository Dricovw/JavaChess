public class EndGameCommand extends Command {
    private String winner;

    public EndGameCommand(String winner) {
        this.winner = winner;
    }


    @Override
    protected String execute() {
        System.out.println(winner + " has won!");
        return null;
    }

    @Override
    public String execute(boolean winner) {
        return null;
    }
}
