export class User {
  constructor(
    public readonly id: string,
    public readonly name: string,
    public readonly emailAddress: string,
    public readonly password: string
  ) {}
}
