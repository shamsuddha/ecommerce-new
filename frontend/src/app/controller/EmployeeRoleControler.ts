import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Page } from "../dto/Page";
import { EmployeeRole } from "../entity/EmployeeRole";
import { EmployeeRoleSearchDto } from "./search_dto/EmployeeRoleSearchDto";

@Injectable({ providedIn: 'root' })
export class CustomerController {


  constructor(private httpClient: HttpClient) { }

  save(employeeRole: EmployeeRole): Observable<EmployeeRole> {
    return this.httpClient.post<EmployeeRole>('http://localhost:8080/employeeRole/save', 
    employeeRole);
  }

  update(employeeRole: EmployeeRole): Observable<EmployeeRole> {
    return this.httpClient.post<EmployeeRole>('http://localhost:8080/employeeRole/update', 
    employeeRole);
  }

  delete(employeeRole: EmployeeRole): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/employeeRole/delete', 
    employeeRole)
  }

  search(employeeRoleSearchDto: EmployeeRoleSearchDto): Observable<Page<EmployeeRole>> {
    return this.httpClient.post<Page<EmployeeRole>>('http://localhost:8080/employeeRole/search', 
    employeeRoleSearchDto);
  }

}
