import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class SellSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];


  constructor(o?: Partial<SellSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
