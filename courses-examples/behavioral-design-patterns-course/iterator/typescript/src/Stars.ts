export class Stars {
  constructor(public readonly value: number) {
    if (value < 1 || value > 5) {
      throw new Error("Invalid stars value");
    }
  }
}
