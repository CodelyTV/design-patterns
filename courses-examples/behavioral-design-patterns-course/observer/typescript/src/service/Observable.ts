import { Observer } from "./Observer";

export abstract class Observable<T> {
  private observers: Observer<T>[] = [];

  addObserver(observer: Observer<T>): void {
    this.observers.push(observer);
  }

  async notify(event: T): Promise<void> {
    this.observers.forEach((observer) => observer.update(event));
  }
}
