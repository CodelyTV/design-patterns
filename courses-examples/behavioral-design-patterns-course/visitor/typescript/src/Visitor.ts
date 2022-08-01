import { ElementA } from "./ElementA";
import { ElementB } from "./ElementB";

export interface Visitor {
  visitElementA(element: ElementA): void;
  visitElementB(element: ElementB): void;
}
