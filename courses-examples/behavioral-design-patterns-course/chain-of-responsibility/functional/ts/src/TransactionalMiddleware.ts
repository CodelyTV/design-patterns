import { Command } from "./Command";
import { Middleware } from "./Middleware";

export function functionalTransactionalMiddleware(next: Middleware): Middleware {
  return function (command: Command): void {
    try {
      next(command);
    } catch (error: unknown) {
      // Rollback
      throw error;
    }
  };
}
