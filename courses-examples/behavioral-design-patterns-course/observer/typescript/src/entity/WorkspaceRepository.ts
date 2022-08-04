import { Workspace } from "./Workspace";

export class WorkspaceRepository {
  save(workspace: Workspace) {
    console.log(workspace);
  }

  find(id: string) {
    return new Workspace(id);
  }
}
