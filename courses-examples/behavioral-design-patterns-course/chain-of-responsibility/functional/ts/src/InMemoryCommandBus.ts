import { Command } from "./Command";
import { CommandHandler } from "./CommandHandler";
import { functionalLoggerMiddleware } from "./LoggerMiddleware";
import { functionalTransactionalMiddleware } from "./TransactionalMiddleware";

export class InMemoryCommandBus {
  constructor(private readonly commandHandler: CommandHandler) {}

  dispatch(command: Command): void {
    const transactionalMiddleware = functionalTransactionalMiddleware(this.commandHandler.handle);
    const loggerMiddleware = functionalLoggerMiddleware(transactionalMiddleware);

    loggerMiddleware(command);
  }
}
