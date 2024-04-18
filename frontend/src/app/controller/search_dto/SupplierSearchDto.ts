import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class SupplierSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<SupplierSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
