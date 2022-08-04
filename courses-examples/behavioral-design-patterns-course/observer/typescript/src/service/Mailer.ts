import { Email } from "./Email";

export class Mailer {
  send = (email: Email) => {
    console.log(email);
  };
}
