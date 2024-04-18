import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { RxFormBuilder, RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { AgGridAngular } from 'ag-grid-angular';
import { Observable, map } from 'rxjs';
import { Employee } from '../../../entity/Employee';
import { EmployeeController } from '../../../controller/EmployeeController';
import { EmployeeSearchDto } from '../../../controller/search_dto/EmployeeSearchDto';

@Component({
  selector: 'EmployeeComp',
  templateUrl: './EmployeeComp.html',
  styleUrls: ['./EmployeeComp.scss'],
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
export class EmployeeComp implements OnInit {

  employeeFg: FormGroup = this.rxFormBuilder.formGroup(Employee);
  //toFaGfn = toFaGfn;
  employeeList$: Observable<Array<Employee>> = new Observable<Array<Employee>>();

  constructor(
    public employeeController: EmployeeController,
    public rxFormBuilder: RxFormBuilder
  ) { }

  ngOnInit(): void {
    this.search();
  }

  save() {
    // console.log(this.employeeFg.value);
    this.employeeController.save(this.employeeFg.value)
      .subscribe((e: Employee) => { console.log(e) });
    this.search();
  }

  onUpdateClick(employee: Employee) {
    this.employeeFg.patchValue(employee);
    this.employeeFg.patchValue({ updateMode: true });
    //this.employeeFg.patchValue({id:employee.id,name:employee.name});
    console.log(this.employeeFg.value);
  }

  update() {
    this.employeeController.update(this.employeeFg.value)
      .subscribe((e) => {
        this.search();
      });
  }

  delete(employee: Employee) {
    this.employeeController.delete(employee)
      .subscribe((e) => {
        this.search();
      });
  }

  search() {
    this.employeeList$ = this.employeeController
      .search(new EmployeeSearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.employeeList$);
  }

  reset() {
    this.employeeFg.reset();
  }

}