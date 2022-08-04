import { Application, Request, Response } from "express";

import { UserRepository } from "../entity/UserRepository";
import { WorkspaceRepository } from "../entity/WorkspaceRepository";
import { AssignUserToWorkspace } from "../service/AssignUserToWorkspace";
import { CreateDefaultWorkspace } from "../service/CreateDefaultWorkspace";
import { Mailer } from "../service/Mailer";
import { SendWelcomeEmail } from "../service/SendWelcomeEmail";
import { UserSignUpServiceManagerHandler } from "../service/UserSignUpServiceManagerHandler";

export const loadApiEndpoints = (app: Application): void => {
  app.get("/api/signup", async (req: Request, res: Response) => {
    const signup = new UserSignUpServiceManagerHandler(new UserRepository());
    const sendWelcomeEmail = new SendWelcomeEmail(new Mailer());
    const workspaceRepository = new WorkspaceRepository();
    const createDefaultWorkspace = new CreateDefaultWorkspace(
      workspaceRepository
    );
    const assignUserToWorkspace = new AssignUserToWorkspace(
      workspaceRepository
    );

    signup.addObserver(sendWelcomeEmail);
    signup.addObserver(createDefaultWorkspace);

    createDefaultWorkspace.addObserver(assignUserToWorkspace);

    await signup.signUp(
      "875c1c7f-d7e8-4c87-8d27-c695b916c60d",
      "Name Surname",
      "soporte@codely.tv",
      "Admin1234"
    );

    return res.status(201).send({});
  });
};
