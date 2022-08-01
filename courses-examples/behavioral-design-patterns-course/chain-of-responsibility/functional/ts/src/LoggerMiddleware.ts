import { Command } from "./Command";
import { Middleware } from "./Middleware";

export class LoggerMiddleware implements Middleware {
  constructor(private readonly next: Middleware) {}

  handle(command: Command): void {
    console.log(`Ejecutando ${command.constructor.name}`);

    this.next.handle(command);
  }
}
