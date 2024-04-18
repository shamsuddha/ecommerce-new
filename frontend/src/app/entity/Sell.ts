import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { Employee } from './Employee';
import { Customer } from './Customer';
import { AuditLog } from './AuditLog';
import { SellDetail } from './SellDetails';

export class Sell extends AuditLog {

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
  employee: Employee | null = null;
  @prop()
  employeeId: string | null = null;

  @prop()
  customer: Customer | null = null;
  @prop()
  customerId: string | null = null;

  @propArray(SellDetail, {createBlank: false})
  sellDetailList: Array<SellDetail> = [];
  sellDetailListSerde: Array<SellDetail> = [];

  constructor(o?: Partial<Sell>) {
    super();
    Object.assign(this, o);
  }
}