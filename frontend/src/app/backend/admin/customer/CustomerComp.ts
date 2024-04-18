import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Observable, map } from 'rxjs';
import { Customer } from '../../../entity/Customer';
import { CustomerController } from '../../../controller/CustomerController';
import { RxFormBuilder, RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { CustomerSearchDto } from '../../../controller/search_dto/CustomerSearchDto';
import { NgSelectModule } from '@ng-select/ng-select';
import { HttpClientModule } from '@angular/common/http';
import { AgGridAngular } from 'ag-grid-angular';

@Component({
  selector: 'CustomerComp',
  templateUrl: './CustomerComp.html',
  styleUrls: ['./CustomerComp.scss'],
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    ReactiveFormsModule,
    RxReactiveFormsModule,
    NgSelectModule,
    HttpClientModule,
    AgGridAngular
  ],
  providers: [],
})
export class CustomerComp implements OnInit {

  customerFg: FormGroup = this.rxFormBuilder.formGroup(Customer);
  //toFaGfn = toFaGfn;
  customerList$: Observable<Array<Customer>> = new Observable<Array<Customer>>();

  constructor(
    public customerController: CustomerController,
    public rxFormBuilder: RxFormBuilder
  ) { }

  ngOnInit(): void {
    this.search();
  }

  save() {
    // console.log(this.customerFg.value);
    this.customerController.save(this.customerFg.value)
      .subscribe((e: Customer) => { console.log(e) });
    this.search();
  }

  onUpdateClick(customer: Customer) {
    this.customerFg.patchValue(customer);
    this.customerFg.patchValue({ updateMode: true });
    //this.customerFg.patchValue({id:customer.id,name:customer.name});
    console.log(this.customerFg.value);
  }

  update() {
    this.customerController.update(this.customerFg.value)
      .subscribe((e) => {
        this.search();
      });
  }

  delete(customer: Customer) {
    this.customerController.delete(customer)
      .subscribe((e) => {
        this.search();
      });
  }

  search() {
    this.customerList$ = this.customerController
      .search(new CustomerSearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.customerList$);
  }

  reset() {
    this.customerFg.reset();
  }

  makeActive(customer: Customer) {
    this.customerController.makeActive(customer).subscribe((e)=> {
      this.search;
    })

   
    }
    

}