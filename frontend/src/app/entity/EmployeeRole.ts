import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { Sell } from './Sell';
import { AuditLog } from './AuditLog';
import { Employee } from './Employee';
import { Role } from './Role';

export class EmployeeRole extends AuditLog {

  @prop()
  id: string | null = null;

  //@propObject(UserInfo, { autoCreate: false })
  @prop()
  employee: Employee | null = null;
  @prop()
  employeeId: string | null = null;

  //@propObject(Role, { autoCreate: false })
  @prop()
  role: Role | null = null;
  @prop()
  roleId: number | null = null;

  constructor(o?: Partial<Employee>) {
    super();
    Object.assign(this, o);
  }

}