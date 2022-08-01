package tv.codely.shared.infrastructure.bus.command;

import tv.codely.shared.domain.Logger;
import tv.codely.shared.domain.bus.command.Command;
import tv.codely.shared.domain.bus.command.Middleware;

import java.util.Optional;

public class LoggerMiddleware<T extends Command> implements Middleware<T> {

    private final Logger logger;
    private final Optional<Middleware<T>> next;

    LoggerMiddleware(Logger logger, Middleware<T> next) {
        this.logger = logger;
        this.next = Optional.of(next);
    }

    @Override
    public void handle(T command) {
        logger.info("Command executed: " + command.getClass().toString());
        next.ifPresent(middleware -> middleware.handle(command));
    }
}
