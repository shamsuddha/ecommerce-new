import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Page } from "../dto/Page";
import { Expense } from "../entity/Expense";
import { ExpenseSearchDto } from "./search_dto/ExpenseSearchDto";

@Injectable({ providedIn: 'root' })
export class ExpenseController {

  constructor(private httpClient: HttpClient,) { }

  save(expense: Expense): Observable<Expense> {
    return this.httpClient.post<Expense>('http://localhost:8080/expense/save', 
    expense);
  }

  update(expense: Expense): Observable<Expense> {
    return this.httpClient.post<Expense>('http://localhost:8080/expense/update', 
    expense);
  }

  delete(expense: Expense): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/expense/delete', 
    expense)
  }

  search(expenseSearchDto: ExpenseSearchDto): Observable<Page<Expense>> {
    return this.httpClient.post<Page<Expense>>('http://localhost:8080/expense/search', 
    expenseSearchDto);
  }

}
