import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class EmployeeSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<EmployeeSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
