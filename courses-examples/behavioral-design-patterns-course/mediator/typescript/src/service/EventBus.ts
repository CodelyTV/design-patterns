import { DomainEvent } from "./DomainEvent";

export interface EventBus {
  notify<T extends DomainEvent>(event: T): void;
}
