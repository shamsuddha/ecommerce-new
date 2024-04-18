import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class ProductCategorySearchDto extends SearchDto {

  @propArray() 
  idList: Array<string> = [];

  constructor(o?: Partial<ProductCategorySearchDto>) {
    super();
    Object.assign(this, o);
  }
}
