package tv.codely.shared.infrastructure.bus.command;

import org.springframework.context.ApplicationContext;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.command.Command;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandler;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.infrastructure.ConsoleLogger;

@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext         context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context     = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            CommandHandler handler = context.getBean(commandHandlerClass);

            var commandHandlerMiddleware = new CommandHandlerMiddleware(handler);
            var transactionalMiddleware = new TransactionalMiddleware(commandHandlerMiddleware);
            var loggerMiddleware = new LoggerMiddleware(new ConsoleLogger(), transactionalMiddleware);

            loggerMiddleware.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
