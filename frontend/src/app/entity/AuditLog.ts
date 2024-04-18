import { prop, } from '@rxweb/reactive-form-validators';

export class AuditLog {

  @prop() createdBy: string | null = null;
  @prop() createdDate: string | null = null;
  @prop() lastModifiedBy: string | null = null;
  @prop() lastModifiedDate: string | null = null;
  @prop() enabled: boolean = true;

  @prop() page: number = 0;
  @prop() size: number = 10;

  @prop() updateMode: boolean = false;
  @prop() loadingMode: boolean = false;

  constructor(o?: Partial<AuditLog>) {
    Object.assign(this, o);
  }
  
}
