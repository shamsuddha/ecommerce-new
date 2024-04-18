import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { Product } from './Product';
import { Purchase } from './Purchase';
import { AuditLog } from './AuditLog';

export class Supplier extends AuditLog {

  @prop()
  id: string | null = null;
  @prop()
  @minLength({ value: 3, message: 'Minimum 3 character required' })
  @maxLength({ value: 10, message: 'Minimum 10 character allowed' })
  @required({ message: 'name is required' })
  name: string | null = null;
  @prop()
  @minLength({ value: 3, message: 'Minimum 3 character required' })
  @maxLength({ value: 10, message: 'Minimum 10 character allowed' })
  company: string | null = null;
  @prop()
  @minLength({ value: 3, message: 'Minimum 3 character required' })
  @maxLength({ value: 10, message: 'Minimum 10 character allowed' })
  address: string | null = null;
  @prop()
  @minLength({ value: 3, message: 'Minimum 3 character required' })
  @maxLength({ value: 15, message: 'Minimum 15 character allowed' })
  phoneNumber: string | null = null;
  @prop()
  currentBalance: number | null = null;
  @propArray(Product, { createBlank: false })
  productList: Array<Product> = [];
  productListSerde: Array<Product> = [];
  @propArray(Purchase, { createBlank: false })
  purchaseList: Array<Purchase> = [];
  purchaseListSerde: Array<Purchase> = [];

  constructor(o?: Partial<Supplier>) {
    super();
    Object.assign(this, o);
  }
  
}