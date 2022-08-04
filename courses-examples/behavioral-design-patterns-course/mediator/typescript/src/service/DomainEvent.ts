export abstract class DomainEvent {
  static EVENT_NAME: string;

  abstract eventName(): string;
}
