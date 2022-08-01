import { Command } from "./Command";

export function functionalTransactionalMiddleware(
  next: (command: Command) => void
): (command: Command) => void {
  return function (command: Command): void {
    try {
      next(command);
    } catch (error: unknown) {
      // Rollback
      throw error;
    }
  };
}
