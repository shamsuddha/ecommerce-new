import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class PaymentSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<PaymentSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
