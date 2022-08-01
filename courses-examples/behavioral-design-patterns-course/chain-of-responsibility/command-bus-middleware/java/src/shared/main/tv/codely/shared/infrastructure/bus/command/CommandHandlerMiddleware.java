package tv.codely.shared.infrastructure.bus.command;

import tv.codely.shared.domain.bus.command.Command;
import tv.codely.shared.domain.bus.command.CommandHandler;
import tv.codely.shared.domain.bus.command.Middleware;

public class CommandHandlerMiddleware<T extends Command> implements Middleware<T> {
    private final CommandHandler<T> commandHandler;

    CommandHandlerMiddleware(CommandHandler<T> commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public void handle(T command) {
        commandHandler.handle(command);
    }
}
