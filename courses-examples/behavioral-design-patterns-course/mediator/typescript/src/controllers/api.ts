import { Application, Request, Response } from "express";

import { UserRepository } from "../entity/UserRepository";
import { WorkspaceRepository } from "../entity/WorkspaceRepository";
import { InMemoryEventBus } from "../service/InMemoryEventBus";
import { Mailer } from "../service/Mailer";
import { SendWelcomeEmailOnUserSignUp } from "../service/SendWelcomeEmailOnUserSignUp";
import { UserSignUpDomainEvent } from "../service/UserSignUpDomainEvent";
import { UserSignUpServiceManagerHandler } from "../service/UserSignUpServiceManagerHandler";

export const loadApiEndpoints = (app: Application): void => {
  app.get("/api/signup", (req: Request, res: Response) => {
    const observers = new Map([
      [
        UserSignUpDomainEvent.EVENT_NAME,
        [new SendWelcomeEmailOnUserSignUp(new Mailer())],
      ],
    ]);

    const eventBus = new InMemoryEventBus(observers);

    const signup = new UserSignUpServiceManagerHandler(
      eventBus,
      new UserRepository(),
      new WorkspaceRepository()
    );

    signup.signUp(
      "875c1c7f-d7e8-4c87-8d27-c695b916c60d",
      "Name Surname",
      "soporte@codely.tv",
      "Admin1234"
    );

    return res.status(201).send({});
  });
};
