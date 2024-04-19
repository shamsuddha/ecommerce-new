import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Purchase } from "../entity/Purchase";
import { PurchaseSearchDto } from "./search_dto/PurchaseSearchDto";
import { Page } from "../dto/Page";
import { PurchaseDetail } from "../entity/PurchaseDetail";

@Injectable({ providedIn: 'root' })
export class PurchaseController {

  constructor(private httpClient: HttpClient,) { }

  save(purchase: Purchase): Observable<Purchase> {
    return this.httpClient.post<Purchase>('http://localhost:8080/purchase/save',
      purchase);
  }

  update(purchase: Purchase): Observable<Purchase> {
    return this.httpClient.post<Purchase>('http://localhost:8080/purchase/update',
      purchase);
  }

  delete(purchase: Purchase): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/purchase/delete',
      purchase)
  }

  search(purchaseSearchDto: PurchaseSearchDto): Observable<Page<Purchase>> {
    return this.httpClient.post<Page<Purchase>>('http://localhost:8080/purchase/search',
      purchaseSearchDto);
  }

  saveWithDetail(purchase: Purchase): Observable<Purchase> {
    return this.httpClient.post<Purchase>('http://localhost:8080/purchase/save-with-purchase-detail', purchase);
  }

  // searchWithDetailAndProduct(purchase: Purchase): Observable<Page<PurchaseDetail>>{
  //   return this.httpClient.post<PurchaseDetail>('http://localhost:8080/purchase/search-with-purchase-detail', purchase);
  // }

}