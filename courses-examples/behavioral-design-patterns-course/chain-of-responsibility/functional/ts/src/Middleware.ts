import { Command } from "./Command";

export interface Middleware {
  handle(command: Command): void;
}
