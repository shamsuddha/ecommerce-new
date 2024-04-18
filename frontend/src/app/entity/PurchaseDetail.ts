import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { AuditLog } from './AuditLog';
import { Purchase } from './Purchase';
import { Product } from './Product';

export class PurchaseDetail extends AuditLog {

  @prop()
  id: string | null = null;
  @prop() 
  @required({ message: ' its is required' })
  quantity: number | null = null;
  @prop() 
  @required({ message: ' its is required' })
  unitPrice: number | null = null;
  
  @prop()
  product: Product | null = null;
  productId: string | null = null;

  @prop()
  purchase: Purchase | null = null;
  @prop()
  purchaseId: string | null = null;

  

  constructor(o?: Partial<PurchaseDetail>) {
    super();
    Object.assign(this, o);
  }
}