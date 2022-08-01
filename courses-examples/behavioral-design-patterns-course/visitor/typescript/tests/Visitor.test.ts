import { ElementA } from "../src/ElementA";
import { ElementB } from "../src/ElementB";
import { ExportVisitor } from "../src/ExportVisitor";
import { PrintVisitor } from "../src/PrintVisitor";
import { ValidatorVisitor } from "../src/ValidatorVisitor";
import { VisitingElement } from "../src/VisitingElement";

describe("Visitor", () => {
  it("print visitor", () => {
    global.console.log = jest.fn();
    const printVisitor = new PrintVisitor();
    const elementA: VisitingElement = new ElementA("ElementA");
    const elementB: VisitingElement = new ElementA("ElementB");

    elementA.accept(printVisitor);
    elementB.accept(printVisitor);

    expect(console.log).nthCalledWith(1, "ElementA");
    expect(console.log).nthCalledWith(2, "ElementB");
  });

  it("validator visitor", () => {
    const validatorVisitor = new ValidatorVisitor();
    const elementA: VisitingElement = new ElementA("");
    const elementB: VisitingElement = new ElementB("ElementB");

    expect(() => elementA.accept(validatorVisitor)).toThrow(Error);
    expect(() => elementB.accept(validatorVisitor)).toThrow(Error);
  });

  it("export visitor", () => {
    const exportVisitor = new ExportVisitor();
    const elementA: VisitingElement = new ElementA("ElementA");
    const elementB: VisitingElement = new ElementB("ElementB");

    elementA.accept(exportVisitor);
    elementB.accept(exportVisitor);

    expect(exportVisitor.readFile()).toBe("ElementAElementB");

    exportVisitor.removeFile();
  });
});
