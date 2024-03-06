public abstract class Command {
    protected abstract String execute();

    public abstract String execute(boolean winner);
}

