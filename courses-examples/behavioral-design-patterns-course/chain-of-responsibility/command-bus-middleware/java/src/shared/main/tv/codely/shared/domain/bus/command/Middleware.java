package tv.codely.shared.domain.bus.command;

public interface Middleware<T extends Command> {
    void handle(T command);
}
