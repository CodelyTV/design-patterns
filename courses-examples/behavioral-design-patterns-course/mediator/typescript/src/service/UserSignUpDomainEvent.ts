import { DomainEvent } from "./DomainEvent";

export class UserSignUpDomainEvent extends DomainEvent {
  static EVENT_NAME = "user_sign_up";

  constructor(public readonly emailAddress: string) {
    super();
  }

  eventName(): string {
    return UserSignUpDomainEvent.EVENT_NAME;
  }
}
