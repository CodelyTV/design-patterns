import { Command } from "./Command";
import { Middleware } from "./Middleware";

export class TransactionalMiddleware implements Middleware {
  constructor(private readonly next: Middleware) {}

  handle(command: Command): void {
    try {
      this.next.handle(command);
    } catch (error: unknown) {
      // Rollback
      throw error;
    }
  }
}
