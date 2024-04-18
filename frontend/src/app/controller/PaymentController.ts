import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Payment } from "../entity/Payment";
import { PaymentSearchDto } from "./search_dto/PaymentSearchDto";
import { Page } from "../dto/Page";

@Injectable({ providedIn: 'root' })
export class PaymentController {

  constructor(private httpClient: HttpClient,) { }

  save(payment: Payment): Observable<Payment> {
    return this.httpClient.post<Payment>('http://localhost:8080/payment/save', 
    payment);
  }

  update(payment: Payment): Observable<Payment> {
    return this.httpClient.post<Payment>('http://localhost:8080/payment/update', 
    payment);
  }

  delete(payment: Payment): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/payment/delete', 
    payment)
  }

  search(paymentSearchDto: PaymentSearchDto): Observable<Page<Payment>> {
    return this.httpClient.post<Page<Payment>>('http://localhost:8080/payment/search', 
    paymentSearchDto);
  }

}
