import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { Sell } from './Sell';
import { AuditLog } from './AuditLog';

export class Customer extends AuditLog {

  @prop()
  id: string | null = null;
  @prop()
  @minLength({ value: 3, message: 'Minimum 3 character required' })
  @maxLength({ value: 10, message: 'Maximum 15 character allowed' })
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
  currentBalance: number | null = null;
  @prop()
  image: string | null = null;
  
  @propArray(Sell, { createBlank: false })
  sellList: Array<Sell> = [];
  sellListSerde: Array<Sell> = [];

  constructor(o?: Partial<Customer>) {
    super();
    Object.assign(this, o);
  }
  
}