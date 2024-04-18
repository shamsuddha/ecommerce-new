import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class ProductSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<ProductSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
