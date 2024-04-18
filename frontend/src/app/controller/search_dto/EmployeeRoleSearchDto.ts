import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class EmployeeRoleSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<EmployeeRoleSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
