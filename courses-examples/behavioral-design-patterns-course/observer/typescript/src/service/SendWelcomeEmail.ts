import { UserRegistered } from "../entity/UserRegistered";
import { Email } from "./Email";
import { Mailer } from "./Mailer";
import { Observer } from "./Observer";

export class SendWelcomeEmail implements Observer<UserRegistered> {
  constructor(private readonly mailer: Mailer) {}

  async update(event: UserRegistered): Promise<void> {
    console.log("2 - Send welcome email");
    const subject = "Welcome to ...";
    const body = "Welcome email body";
    this.mailer.send(new Email(event.emailAddress, subject, body));
  }
}
