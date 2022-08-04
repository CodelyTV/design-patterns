import { DomainEvent } from "./DomainEvent";

export interface Observer<T extends DomainEvent> {
  update(event: T): void;
}
