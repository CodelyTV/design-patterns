import { Visitor } from "./Visitor";

export interface VisitingElement {
  accept(visitor: Visitor): void;
}
