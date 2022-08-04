import { DomainEvent } from "./DomainEvent";
import { EventBus } from "./EventBus";
import { Observer } from "./Observer";

export class InMemoryEventBus implements EventBus {
  constructor(
    private readonly observers: Map<string, Observer<DomainEvent>[]>
  ) {}

  notify<T extends DomainEvent>(event: T): void {
    const observers = this.observers.get(event.eventName());

    if (observers) {
      observers.forEach((observer) => observer.update(event));
    }
  }
}
