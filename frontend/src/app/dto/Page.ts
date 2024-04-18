
export class Page<T> {

  content: Array<T> = [];

  constructor(o?: Partial<Page<T>>) {
    Object.assign(this, o);
  }
}
