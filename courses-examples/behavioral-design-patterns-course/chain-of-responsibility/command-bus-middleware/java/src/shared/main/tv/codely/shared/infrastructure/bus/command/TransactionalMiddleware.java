package tv.codely.shared.infrastructure.bus.command;

import tv.codely.shared.domain.bus.command.Command;
import tv.codely.shared.domain.bus.command.Middleware;
import tv.codely.shared.infrastructure.ConsoleLogger;

import java.util.Optional;

public class TransactionalMiddleware<T extends Command> implements Middleware<T> {
    private final TransactionManager transactionManager;
    private Optional<Middleware<T>> next;

    TransactionalMiddleware(Middleware<T> next) {
        this.next = Optional.of(next);
        this.transactionManager = new TransactionManager();
    }

    @Override
    public void handle(T command) {
        transactionManager.begin();
        try {
            next.ifPresent(middleware -> middleware.handle(command));
            transactionManager.commit();
        } catch (Throwable e) {
            transactionManager.rollback();
            throw e;
        }
    }

    static class TransactionManager {

        private final ConsoleLogger logger;

        TransactionManager() {
            this.logger = new ConsoleLogger();
        }

        void begin() {
            this.logger.info("BEGIN");
        }
        void commit() {
            this.logger.info("COMMIT");
        }
        void rollback() {
            this.logger.info("ROLLBACK");
        }
    }
}
