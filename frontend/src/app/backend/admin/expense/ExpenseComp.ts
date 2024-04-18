import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { RxFormBuilder, RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { AgGridAngular } from 'ag-grid-angular';
import { Observable, map } from 'rxjs';
import { Expense } from '../../../entity/Expense';
import { ExpenseController } from '../../../controller/ExpenseController';
import { ExpenseSearchDto } from '../../../controller/search_dto/ExpenseSearchDto';

@Component({
 selector: 'ExpenseComp',
 templateUrl: './ExpenseComp.html',
 styleUrls: ['./ExpenseComp.scss'],
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
export class ExpenseComp implements OnInit {

  expenseFg: FormGroup = this.rxFormBuilder.formGroup(Expense);
  //toFaGfn = toFaGfn;
  expenseList$: Observable<Array<Expense>> = new Observable<Array<Expense>>();

  constructor(
    public expenseController: ExpenseController,
    public rxFormBuilder: RxFormBuilder
  ) { }

  ngOnInit(): void {
    this.search();
  }

  save() {
    // console.log(this.expenseFg.value);
    this.expenseController.save(this.expenseFg.value)
      .subscribe((e: Expense) => { console.log(e) });
    this.search();
  }

  onUpdateClick(expense: Expense) {
    this.expenseFg.patchValue(expense);
    this.expenseFg.patchValue({ updateMode: true });
    //this.expenseFg.patchValue({id:expense.id,name:expense.name});
    console.log(this.expenseFg.value);
  }

  update() {
    this.expenseController.update(this.expenseFg.value)
      .subscribe((e) => {
        this.search();
      });
  }

  delete(expense: Expense) {
    this.expenseController.delete(expense)
      .subscribe((e) => {
        this.search();
      });
  }

  search() {
    this.expenseList$ = this.expenseController
      .search(new ExpenseSearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.expenseList$);
  }

  reset() {
    this.expenseFg.reset();
  }

}