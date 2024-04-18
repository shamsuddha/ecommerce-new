import { prop, propArray } from "@rxweb/reactive-form-validators";
import { SearchDto } from "./SearchDto";

export class RoleSearchDto extends SearchDto {

  @propArray() idList: Array<string> = [];

  constructor(o?: Partial<RoleSearchDto>) {
    super();
    Object.assign(this, o);
  }
}
