import { Role } from "../entity/Role";
import { User } from "../entity/User";
import { UserRepository } from "../entity/UserRepository";
import { Workspace } from "../entity/Workspace";
import { WorkspaceRepository } from "../entity/WorkspaceRepository";
import { Email } from "./Email";
import { Mailer } from "./Mailer";

export class UserSignUpServiceManagerHandler {
  constructor(
    private readonly mailer: Mailer,
    private readonly userRepository: UserRepository,
    private readonly workspaceRepository: WorkspaceRepository
  ) {}

  signUp(
    id: string,
    name: string,
    emailAddress: string,
    password: string
  ): void {
    console.log("1 - Register user");
    const user = new User(id, name, emailAddress, password);
    this.userRepository.save(user);

    console.log("2 - Send welcome email");
    const subject = "Welcome to ...";
    const body = "Welcome email body";
    this.mailer.send(new Email(emailAddress, subject, body));

    console.log("3 - Create default workspace");
    const workspace = Workspace.default();
    this.workspaceRepository.save(workspace);

    console.log("4 - Assign user to workspace");
    workspace.assignUser(user.id, Role.admin);
  }
}
