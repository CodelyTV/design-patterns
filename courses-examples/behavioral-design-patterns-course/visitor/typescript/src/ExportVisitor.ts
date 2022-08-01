import fs from "fs";

import { ElementA } from "./ElementA";
import { ElementB } from "./ElementB";
import { Visitor } from "./Visitor";

export class ExportVisitor implements Visitor {
  private readonly _path = "test.txt";

  visitElementA(element: ElementA): void {
    fs.writeFileSync(this._path, element.name, { flag: "a" });
  }

  visitElementB(element: ElementB): void {
    fs.writeFileSync(this._path, element.title, { flag: "a" });
  }

  readFile(): string {
    return fs.readFileSync(this._path, { flag: "r" }).toString();
  }

  removeFile(): void {
    fs.unlinkSync(this._path);
  }
}
