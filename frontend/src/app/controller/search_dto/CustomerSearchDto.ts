import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class CustomerSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<CustomerSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
