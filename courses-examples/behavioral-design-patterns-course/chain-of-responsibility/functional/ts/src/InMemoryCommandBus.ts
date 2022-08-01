import { Command } from "./Command";
import { CommandHandler } from "./CommandHandler";
import { LoggerMiddleware } from "./LoggerMiddleware";
import { TransactionalMiddleware } from "./TransactionalMiddleware";

export class InMemoryCommandBus {
  constructor(private readonly commandHandler: CommandHandler) {}

  dispatch(command: Command): void {
    const transactionalMiddleware = new TransactionalMiddleware(this.commandHandler);
    const loggerMiddleware = new LoggerMiddleware(transactionalMiddleware);

    loggerMiddleware.handle(command);
  }
}
