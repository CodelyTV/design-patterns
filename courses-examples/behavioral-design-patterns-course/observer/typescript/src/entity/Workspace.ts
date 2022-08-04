import { Role } from "./Role";

export class Workspace {
  constructor(public readonly id: string) {}

  static default(): Workspace {
    return new Workspace("fake random uuid");
  }

  assignUser(user: string, role: Role): void {
    console.log(`User ${user} assigned to default workspace with role ${role}`);
  }
}
