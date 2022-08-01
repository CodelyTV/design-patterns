import { Command } from "./Command";

export function functionalLoggerMiddleware(
  next: (command: Command) => void
): (command: Command) => void {
  return function (command: Command): void {
    console.log(`Ejecutando ${command.constructor.name}`);

    next(command);
  };
}
