export class Email {
  constructor(
    private readonly to: string,
    private readonly subject: string,
    private readonly body: string
  ) {}
}
