import { Command } from "./Command";

export interface CommandHandler {
  handle(command: Command): void;
}
