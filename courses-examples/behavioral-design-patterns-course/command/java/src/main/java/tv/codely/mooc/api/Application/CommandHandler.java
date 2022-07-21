package tv.codely.mooc.api.Application;

public abstract class CommandHandler<T extends Command, R> {
    public R execute(T command) {
        var result = this.run(command);
        this.log(command);
        return result;
    }

    abstract protected void log(T command);
    abstract protected R run(T command);
}
