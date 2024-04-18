import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Supplier } from "../entity/Supplier";
import { SupplierSearchDto } from "./search_dto/SupplierSearchDto";
import { Page } from "../dto/Page";

@Injectable({ providedIn: 'root' })
export class SupplierController {

  constructor(private httpClient: HttpClient,) { }

  save(supplier: Supplier): Observable<Supplier> {
    return this.httpClient.post<Supplier>('http://localhost:8080/supplier/save', supplier);
  }

  update(supplier: Supplier): Observable<Supplier> {
    return this.httpClient.post<Supplier>('http://localhost:8080/supplier/update', supplier);
  }

  delete(supplier: Supplier): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/supplier/delete', supplier);
   
  }

  search(supplierSearchDto: SupplierSearchDto): Observable<Page<Supplier>> {
    return this.httpClient.post<Page<Supplier>>('http://localhost:8080/supplier/search', supplierSearchDto);
  }
  
}
