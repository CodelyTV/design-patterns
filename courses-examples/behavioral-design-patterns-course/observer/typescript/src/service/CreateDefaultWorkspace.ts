import { DefaultWorkspaceCreated } from "../entity/DefaultWorkspaceCreated";
import { UserRegistered } from "../entity/UserRegistered";
import { Workspace } from "../entity/Workspace";
import { WorkspaceRepository } from "../entity/WorkspaceRepository";
import { Observable } from "./Observable";
import { Observer } from "./Observer";

export class CreateDefaultWorkspace
  extends Observable<DefaultWorkspaceCreated>
  implements Observer<UserRegistered>
{
  constructor(private readonly workspaceRepository: WorkspaceRepository) {
    super();
  }

  async update(event: UserRegistered): Promise<void> {
    console.log("3 - Create default workspace");
    const workspace = Workspace.default();
    this.workspaceRepository.save(workspace);
    await this.notify(new DefaultWorkspaceCreated(workspace.id, event.id));
  }
}
