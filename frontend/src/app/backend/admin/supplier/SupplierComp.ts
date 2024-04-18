import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Supplier } from '../../../entity/Supplier';
import { Observable, map } from 'rxjs';
import { RxFormBuilder, RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { NgSelectModule } from '@ng-select/ng-select';
import { HttpClientModule } from '@angular/common/http';
import { SupplierController } from '../../../controller/SupplierController';
import { SupplierSearchDto } from '../../../controller/search_dto/SupplierSearchDto';

@Component({
  selector: 'SupplierComp',
  templateUrl: './SupplierComp.html',
  styleUrls: ['./SupplierComp.scss'],
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    ReactiveFormsModule,
    RxReactiveFormsModule,
    NgSelectModule,
    HttpClientModule
  ],
  providers: [],
})
export class SupplierComp implements OnInit {
  
  supplierFg: FormGroup = this.rxFormBuilder.formGroup(Supplier);
  //toFaGfn = toFaGfn;
  supplierList$: Observable<Array<Supplier>> = new Observable<Array<Supplier>>();

  constructor(
    public supplierController: SupplierController,
    public rxFormBuilder: RxFormBuilder
  ) { }

  ngOnInit(): void {
    this.search();
  }

  save() {
    // console.log(this.supplierFg.value);
    this.supplierController.save(this.supplierFg.value)
      .subscribe((e: Supplier) => { console.log(e) });
    this.search();
  }

  onUpdateClick(supplier: Supplier) {
    this.supplierFg.patchValue(supplier);
    this.supplierFg.patchValue({ updateMode: true });
    //this.supplierFg.patchValue({id:supplier.id,name:supplier.name});
    console.log(this.supplierFg.value);
  }

  update() {
    this.supplierController.update(this.supplierFg.value)
      .subscribe((e) => {
        this.search();
      });
  }

  delete(supplier: Supplier) {
    this.supplierController.delete(supplier)
      .subscribe((e) => {
        this.search();
      });
  }

  search() {
    this.supplierList$ = this.supplierController
      .search(new SupplierSearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.supplierList$);
  }

  reset() {
    this.supplierFg.reset();
    }

}