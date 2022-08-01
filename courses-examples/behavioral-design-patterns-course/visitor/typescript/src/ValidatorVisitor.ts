import { ElementA } from "./ElementA";
import { ElementB } from "./ElementB";
import { Visitor } from "./Visitor";

export class ValidatorVisitor implements Visitor {
  visitElementA(element: ElementA): void {
    if (element.name.length === 0) {
      throw new Error("ElementA name can't be empty");
    }
  }

  visitElementB(element: ElementB): void {
    if (element.title.length > 5) {
      throw new Error("ElementB title is too long");
    }
  }
}
