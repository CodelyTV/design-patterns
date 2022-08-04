import { Email } from "./Email";
import { Mailer } from "./Mailer";
import { Observer } from "./Observer";
import { UserSignUpDomainEvent } from "./UserSignUpDomainEvent";

export class SendWelcomeEmailOnUserSignUp
  implements Observer<UserSignUpDomainEvent>
{
  constructor(private mailer: Mailer) {}

  update(event: UserSignUpDomainEvent): void {
    console.log("2 - Send welcome email");
    const subject = "Welcome to ...";
    const body = "Welcome email body";
    this.mailer.send(new Email(event.emailAddress, subject, body));
  }
}
