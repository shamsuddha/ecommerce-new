import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Sell } from "../entity/Sell";
import { SellSearchDto } from "./search_dto/SellSearchDto";
import { Page } from "../dto/Page";

@Injectable({ providedIn: 'root' })
export class SellController {

  constructor(private httpClient: HttpClient,) { }

  save(sell: Sell): Observable<Sell> {
    return this.httpClient.post<Sell>('http://localhost:8080/sell/save', sell);
  }

  update(sell: Sell): Observable<Sell> {
    return this.httpClient.post<Sell>('http://localhost:8080/sell/update', sell);
  }

  delete(sell: Sell): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/sell/delete', sell)
  }

  search(sellSearchDto: SellSearchDto): Observable<Page<Sell>> {
    return this.httpClient.post<Page<Sell>>('http://localhost:8080/sell/search', sellSearchDto);
  }

}
