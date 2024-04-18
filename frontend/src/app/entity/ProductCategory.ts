import { maxLength, minLength, prop, propArray, required }
  from '@rxweb/reactive-form-validators';
import { AuditLog } from './AuditLog';
import { Product } from './Product';

export class ProductCategory extends AuditLog {
  
  @prop()
  id: string | null = null;
  @prop()
  @minLength({ value: 3, message: 'Minimum 3 character required' })
  @maxLength({ value: 15, message: 'Maximum 15 character allowed' })
  @required({ message: 'name is required' })
  name: string | null = null;
  @prop()
  image: string | null = null;
  @prop()
  slug: string | null = null;
 
  @propArray(Product, {createBlank: false})
  productList: Array<Product> = [];
  productListSerde: Array<Product> = [];

  constructor(o?: Partial<ProductCategory>) {
    super();
    Object.assign(this, o);
  }
}