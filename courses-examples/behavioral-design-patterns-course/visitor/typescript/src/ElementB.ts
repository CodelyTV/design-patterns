import { VisitingElement } from "./VisitingElement";
import { Visitor } from "./Visitor";

export class ElementB implements VisitingElement {
  constructor(public readonly title: string) {}

  accept(visitor: Visitor) {
    visitor.visitElementB(this);
  }
}
