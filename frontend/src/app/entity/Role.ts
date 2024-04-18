import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { AuditLog } from './AuditLog';
import { EmployeeRole } from './EmployeeRole';

export class Role extends AuditLog {

  @prop()
  id: string | null = null;
  @prop() @minLength({ value: 3, message: 'Minimum 3 character required' })
  @maxLength({ value: 10, message: 'Minimum 10 character allowed' })
  @pattern({
    expression: {
      atLeastOneUpperCaseAndLowerCaseLatter: /(?=.*[a-z])(?=.*[A-Z])/gm,
    },
  })
  @numeric({ acceptValue: NumericValueType.PositiveNumber, allowDecimal: false, })
  @trim()
  @required({ message: 'name is required' })
  name: string | null = null;

  @propArray(EmployeeRole, { createBlank: false })
  employeeRoleList: Array<EmployeeRole> = [];
  employeeRoleListSerde: Array<EmployeeRole> = [];

  constructor(o?: Partial<Role>) {
    super();
    Object.assign(this, o);
  }

}