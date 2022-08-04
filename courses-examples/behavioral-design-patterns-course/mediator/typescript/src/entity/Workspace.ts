import { Role } from "./Role";

export class Workspace {
  static default(): Workspace {
    return new Workspace();
  }

  assignUser(user: string, role: Role): void {
    console.log(`User ${user} assigned to default workspace with role ${role}`);
  }
}
