import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { RxFormBuilder, RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { AgGridAngular } from 'ag-grid-angular';
import { Purchase } from '../../../entity/Purchase';
import { Observable, map } from 'rxjs';
import { PurchaseController } from '../../../controller/PurchaseController';
import { PurchaseSearchDto } from '../../../controller/search_dto/PurchaseSearchDto';
import { Employee } from '../../../entity/Employee';
import { Supplier } from '../../../entity/Supplier';
import { EmployeeController } from '../../../controller/EmployeeController';
import { EmployeeSearchDto } from '../../../controller/search_dto/EmployeeSearchDto';
import { SupplierSearchDto } from '../../../controller/search_dto/SupplierSearchDto';
import { SupplierController } from '../../../controller/SupplierController';
import { toFaGfn } from '../../../util/MiscUtil';
import { PurchaseDetail } from '../../../entity/PurchaseDetail';
import { Product } from '../../../entity/Product';
import { ProductController } from '../../../controller/ProductController';
import { ProductSearchDto } from '../../../controller/search_dto/ProductSearchDto';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { DialogComp } from './dialog/DialogComp';

@Component({
  selector: 'PurchaseComp',
  templateUrl: './PurchaseComp.html',
  styleUrls: ['./PurchaseComp.scss'],
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    ReactiveFormsModule,
    RxReactiveFormsModule,
    NgSelectModule,
    HttpClientModule,
    AgGridAngular,
    MatDialogModule
  ],
  providers: [],
})
export class PurchaseComp implements OnInit {

  toFaGfn = toFaGfn;
  purchaseFg: FormGroup = this.rxFormBuilder.formGroup(Purchase);
  purchaseList$: Observable<Array<Purchase>> = new Observable<Array<Purchase>>();
  employeeList$: Observable<Array<Employee>> = new Observable<Array<Employee>>();
  supplierList$: Observable<Array<Supplier>> = new Observable<Array<Supplier>>();
  productList$: Observable<Array<Product>> = new Observable<Array<Product>>();
  purchaseDetailAndProductList$: Observable<Array<PurchaseDetail>> = new Observable<Array<PurchaseDetail>>();

  constructor(
    public employeeController: EmployeeController,
    public supplierController: SupplierController,
    public purchaseController: PurchaseController,
    public productController: ProductController,
    public rxFormBuilder: RxFormBuilder,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {

    this.employeeList$ = this.employeeController
      .search(new EmployeeSearchDto({ "idList": [] }))
      .pipe(
        map(e => e.content.filter((e) => e.enabled == true))
      );

    this.supplierList$ = this.supplierController
      .search(new SupplierSearchDto({ "idList": [] }))
      .pipe(
        map(e => e.content.filter((e) => e.enabled == true))
      );

    this.productList$ = this.productController
      .search(new ProductSearchDto({ "idList": [] }))
      .pipe(
        map(e => e.content.filter((e) => e.enabled == true))
      );

    this.search();
  }

  save() {
    let purchase: Purchase = this.purchaseFg.value;
    purchase.purchaseDetailListSerde = purchase.purchaseDetailList;
    this.purchaseController.saveWithDetail(purchase).subscribe((e) => {
      this.search();
    });
  }

  onUpdateClick(purchase: Purchase) {
    this.purchaseFg.patchValue(purchase);
    this.purchaseFg.patchValue({ updateMode: true });
    //this.purchaseFg.patchValue({id:purchase.id,name:purchase.name});
    console.log(this.purchaseFg.value);
  }

  update() {
    this.purchaseController.update(this.purchaseFg.value)
      .subscribe((e) => {
        this.search();
      });
  }

  delete(purchase: Purchase) {
    this.purchaseController.delete(purchase)
      .subscribe((e) => {
        this.search();
      });
  }

  search() {
    this.purchaseList$ = this.purchaseController
      .search(new PurchaseSearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.purchaseList$);
  }

  reset() {
    this.purchaseFg.reset();
  }


  addPurchaseDetail() {
    (<FormArray>this.purchaseFg.get('purchaseDetailList'))
      .push(this.rxFormBuilder.formGroup(PurchaseDetail));
  }

  deleteDetail(fg: AbstractControl, index: number) {
    console.log((<FormGroup>fg).value)
  }

  openDialog(purchase: Purchase) {
   // this.purchaseDetailAndProductList$ = this.purchaseController.searchWithDetailAndProduct(purchase)
    const dialogRef = this.dialog.open(DialogComp);
    console.log(purchase);

    dialogRef.afterClosed().subscribe(result => {

    });
  }

  searchWithDetailAndProduct() {
    this.purchaseList$ = this.purchaseController
      .search(new PurchaseSearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.purchaseList$);
  }

}
