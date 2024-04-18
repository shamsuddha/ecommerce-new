import { NumericValueType, maxLength, minLength, numeric, pattern, prop, propArray, propObject, required, trim }
  from '@rxweb/reactive-form-validators';
import { ProductCategory } from './ProductCategory';
import { AuditLog } from './AuditLog';

export class Product extends AuditLog {

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
  code: string | null = null;
  @prop()
  currentStock: number | null = null;
  @prop()
  buyingPrice: number | null = null;
  @prop()
  sellingPrice: number | null = null;
  @prop()
  description: string | null = null;
  @prop()
  image: string | null = null;
  @prop()
  productCategory: ProductCategory | null = null;
  productCategoryId: string | null = null;

  constructor(o?: Partial<Product>) {
    super();
    Object.assign(this, o);
  }

}