import { VisitingElement } from "./VisitingElement";
import { Visitor } from "./Visitor";

export class ElementA implements VisitingElement {
  constructor(public readonly name: string) {}

  accept(visitor: Visitor) {
    visitor.visitElementA(this);
  }
}
