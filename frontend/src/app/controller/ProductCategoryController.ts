import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ProductCategory } from "../entity/ProductCategory";
import { Observable } from "rxjs";
import { ProductCategorySearchDto } from "./search_dto/ProductCategorySearchDto";
import { Page } from "../dto/Page";

@Injectable({ providedIn: 'root' })
export class ProductCategoryController {

  constructor(private httpClient: HttpClient) { }

  save(productCategory: ProductCategory): Observable<ProductCategory> {
    return this.httpClient.post<ProductCategory>('http://localhost:8080/product-category/save', 
    productCategory);
  }

  update(productCategory: ProductCategory): Observable<ProductCategory> {
    return this.httpClient.post<ProductCategory>('http://localhost:8080/product-category/update', 
    productCategory);
  }

  delete(productCategory: ProductCategory): Observable<boolean> {
    return this.httpClient.post<boolean>('http://localhost:8080/product-category/delete', 
    productCategory)
  }

  search(productCategorySearchDto: ProductCategorySearchDto): Observable<Page<ProductCategory>> {
    return this.httpClient.post<Page<ProductCategory>>('http://localhost:8080/product-category/search', 
    productCategorySearchDto);
  }

}
