import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class ExpenseSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<ExpenseSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
