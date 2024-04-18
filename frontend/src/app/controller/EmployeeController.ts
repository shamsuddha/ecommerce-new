import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../entity/Employee";
import { EmployeeSearchDto } from "./search_dto/EmployeeSearchDto";
import { Page } from "../dto/Page";

@Injectable({ providedIn: 'root' })
export class EmployeeController {

  constructor(private httpClient: HttpClient) { }

  save(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>('http://localhost:8080/employee/save', 
    employee);
  }

  update(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>('http://localhost:8080/employee/update', 
    employee);
  }

  delete(employee: Employee): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/employee/delete', 
    employee)
  }

  search(employeeSearchDto: EmployeeSearchDto): Observable<Page<Employee>> {
    return this.httpClient.post<Page<Employee>>('http://localhost:8080/employee/search', 
    employeeSearchDto);
  }

}
