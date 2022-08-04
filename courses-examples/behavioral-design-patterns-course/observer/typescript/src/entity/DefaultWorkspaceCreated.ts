export class DefaultWorkspaceCreated {
  constructor(
    public readonly workspaceId: string,
    public readonly userId: string
  ) {}
}
