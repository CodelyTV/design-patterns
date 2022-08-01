import { Command } from "./Command";

export type Middleware = (command: Command) => void;
