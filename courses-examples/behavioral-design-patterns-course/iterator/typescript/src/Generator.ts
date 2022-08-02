export function* generator(...values: number[]): Generator<number, void> {
  for (const value of values) {
    yield value;
    console.log("continue!");
  }
}
