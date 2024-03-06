public class EndGameCommand extends Command {
    private String winner;

    public EndGameCommand(String winner) {
        this.winner = winner;
    }

    @Override
    public String execute() {
        // Print the end game message with the provided winner
        System.out.println("Game finished! Winner: " + winner);

        // Return a message indicating the game is finished and who won
        return null;
    }
}
