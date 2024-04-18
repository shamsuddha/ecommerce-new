import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Customer } from "../entity/Customer";
import { CustomerSearchDto } from "./search_dto/CustomerSearchDto";
import { Page } from "../dto/Page";

@Injectable({ providedIn: 'root' })
export class CustomerController {

  constructor(private httpClient: HttpClient) { }

  save(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>('http://localhost:8080/customer/save', 
    customer);
  }

  update(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>('http://localhost:8080/customer/update', 
    customer);
  }

  delete(customer: Customer): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/customer/delete', 
    customer)
  }

  search(customerSearchDto: CustomerSearchDto): Observable<Page<Customer>> {
    return this.httpClient.post<Page<Customer>>('http://localhost:8080/customer/search', 
    customerSearchDto);
  }

  makeActive(customer: Customer) {
    return this.httpClient.post<boolean>('http://localhost:8080/customer/make-active', 
    customer)
  }

}
