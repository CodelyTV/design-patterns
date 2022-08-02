import { generator } from "../src/Generator";

describe("Iterator should", () => {
  it("saves and restores a Course", () => {
    for (const value of generator(1, 2, 3, 4, 5)) {
      console.log(value);
    }
  });
});
