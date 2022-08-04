import { DefaultWorkspaceCreated } from "../entity/DefaultWorkspaceCreated";
import { Role } from "../entity/Role";
import { WorkspaceRepository } from "../entity/WorkspaceRepository";
import { Observer } from "./Observer";

export class AssignUserToWorkspace
  implements Observer<DefaultWorkspaceCreated>
{
  constructor(private readonly workspaceRepository: WorkspaceRepository) {}

  update(event: DefaultWorkspaceCreated): void {
    console.log("4 - Assign user to workspace");
    const workspace = this.workspaceRepository.find(event.workspaceId);
    workspace.assignUser(event.userId, Role.admin);
  }
}
