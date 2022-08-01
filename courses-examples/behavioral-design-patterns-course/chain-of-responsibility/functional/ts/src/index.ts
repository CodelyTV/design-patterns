import { InMemoryCommandBus } from "./InMemoryCommandBus";

const commandBus = new InMemoryCommandBus();
commandBus.dispatch();
