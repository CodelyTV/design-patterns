import { Command } from "./Command";
import { Middleware } from "./Middleware";

export function functionalLoggerMiddleware(next: Middleware): Middleware {
  return function (command: Command): void {
    console.log(`Ejecutando ${command.constructor.name}`);

    next(command);
  };
}
