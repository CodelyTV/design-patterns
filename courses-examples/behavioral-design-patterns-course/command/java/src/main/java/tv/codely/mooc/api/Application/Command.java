package tv.codely.mooc.api.Application;

public abstract class Command {
    public void execute() {
        this.run();
        this.log();
    }

    abstract protected void log();
    abstract protected void run();
}
