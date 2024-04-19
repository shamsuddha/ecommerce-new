import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Purchase } from "../entity/Purchase";
import { PurchaseSearchDto } from "./search_dto/PurchaseSearchDto";
import { Page } from "../dto/Page";

@Injectable({ providedIn: 'root' })
export class PurchaseDetailController {

  constructor(private httpClient: HttpClient,) { }

  searchWithPurchaseAndProduct(purchase: Purchase): Observable<Purchase> {
    return this.httpClient.post<Purchase>('http://localhost:8080/purchase/save-with-purchase-detail', purchase);
  }

}