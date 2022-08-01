import { DomainEvent } from "./DomainEvent";

export class AggregateRoot {
  private recordedEvents: DomainEvent[] = [];

  record(domainEvent: DomainEvent): void {
    this.recordedEvents.push(domainEvent);
  }

  pullDomainEvents(): DomainEvent[] {
    const events = this.recordedEvents;
    this.recordedEvents = [];
    return events;
  }
}
