import { prop, propArray, } from '@rxweb/reactive-form-validators';
import { PurchaseDetail } from '../../entity/PurchaseDetail';

export class PurchaseDetailSearchDto {

  @prop() page: number = 0;
  @prop() size: number = 10;
  @propArray() idList: Array<PurchaseDetail> = [];

  constructor(o?: Partial<PurchaseDetailSearchDto>) {
    Object.assign(this, o);
  }
}