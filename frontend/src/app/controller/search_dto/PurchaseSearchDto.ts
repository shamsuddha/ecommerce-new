import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class PurchaseSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<PurchaseSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
