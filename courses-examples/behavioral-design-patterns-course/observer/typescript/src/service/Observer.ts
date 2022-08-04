export interface Observer<T> {
  update(event: T): void;
}
