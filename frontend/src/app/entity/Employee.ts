import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { AuditLog } from './AuditLog';
import { Purchase } from './Purchase';
import { EmployeeRole } from './EmployeeRole';
import { Sell } from './Sell';

export class Employee extends AuditLog {

  @prop()
  id: string | null = null;
  @prop()
  @minLength({ value: 3, message: 'Minimum 3 character required' })
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
  @prop()
  email: string | null = null;
  @prop()
  phone: string | null = null;
  @prop()
  address: string | null = null;
  @prop()
  image: string | null = null;

  @propArray(Purchase, { createBlank: false })
  purchaseList: Array<Purchase> = [];
  purchaseListSerde: Array<Purchase> = [];

  @propArray(EmployeeRole, { createBlank: false })
  employeeRoleList: Array<EmployeeRole> = [];
  employeeRoleListSerde: Array<EmployeeRole> = [];

  @propArray(Sell, { createBlank: false })
  sellList: Array<Sell> = [];
  sellListSerde: Array<Sell> = [];

  constructor(o?: Partial<Employee>) {
    super();
    Object.assign(this, o);
  }
  
}