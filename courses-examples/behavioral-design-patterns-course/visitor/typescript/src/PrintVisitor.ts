import { ElementA } from "./ElementA";
import { ElementB } from "./ElementB";
import { Visitor } from "./Visitor";

export class PrintVisitor implements Visitor {
  visitElementA(element: ElementA): void {
    console.log(element.name);
  }

  visitElementB(element: ElementB): void {
    console.log(element.title);
  }
}
