import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Page } from "../dto/Page";
import { Role } from "../entity/Role";
import { RoleSearchDto } from "./search_dto/RoleSearchDto";

@Injectable({ providedIn: 'root' })
export class CustomerController {

  constructor(private httpClient: HttpClient) { }

  save(role: Role): Observable<Role> {
    return this.httpClient.post<Role>('http://localhost:8080/role/save', role);
  }

  update(role: Role): Observable<Role> {
    return this.httpClient.post<Role>('http://localhost:8080/role/update', role);
  }

  delete(role: Role): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/role/delete', role)
  }

  search(roleSearchDto: RoleSearchDto): Observable<Page<Role>> {
    return this.httpClient.post<Page<Role>>('http://localhost:8080/role/search', roleSearchDto);  
  }

}
