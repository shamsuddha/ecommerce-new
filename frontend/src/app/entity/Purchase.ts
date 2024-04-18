import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { AuditLog } from './AuditLog';
import { Supplier } from './Supplier';
import { Employee } from './Employee';

export class Purchase extends AuditLog {

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
  @required({ message: 'note is required' })
  note: string | null = null;
  @prop()
  totalAmount: number | null = null;
  @prop()
  otherCost: number | null = null;

  @prop()
  supplier: Supplier | null = null;
  @prop()
  SupplierId: string | null = null;

  @prop()
  employee: Employee | null = null;
  @prop()
  employeeId: string | null = null;

  @propArray(Purchase, {createBlank: false})
  purchaseDetailList: Array<Purchase> = [];
  purchaseDetailListSerde: Array<Purchase> = [];

  constructor(o?: Partial<Purchase>) {
    super();
    Object.assign(this, o);
  }
}