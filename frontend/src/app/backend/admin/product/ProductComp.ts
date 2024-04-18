import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { RxFormBuilder, RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { AgGridAngular } from 'ag-grid-angular';
import { Product } from '../../../entity/Product';
import { Observable, map } from 'rxjs';
import { ProductController } from '../../../controller/ProductController';
import { ProductCategoryController } from '../../../controller/ProductCategoryController';
import { ProductCategory } from '../../../entity/ProductCategory';
import { ProductSearchDto } from '../../../controller/search_dto/ProductSearchDto';
import { ProductCategorySearchDto } from '../../../controller/search_dto/ProductCategorySearchDto';

@Component({
  selector: 'ProductComp',
  templateUrl: './ProductComp.html',
  styleUrls: ['./ProductComp.scss'],
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    ReactiveFormsModule,
    RxReactiveFormsModule,
    NgSelectModule,
    HttpClientModule,
    AgGridAngular
  ],
  providers: [],
})
export class ProductComp implements OnInit {

  productFg: FormGroup = this.rxFormBuilder.formGroup(Product);
  //toFaGfn = toFaGfn;
  productList$: Observable<Array<Product>> = new Observable<Array<Product>>();
  productCategoryList$: Observable<Array<ProductCategory>> = new Observable<Array<ProductCategory>>();

  constructor(
    public productController: ProductController,
    public productCategoryController: ProductCategoryController,
    public rxFormBuilder: RxFormBuilder
  ) { }

  ngOnInit(): void {
    this.productCategoryList$ = this.productCategoryController
      .search(new ProductCategorySearchDto({ "idList": [] }))
      .pipe(
        map(e => e.content.filter((e) => e.enabled == true))
      )
    this.search();
  }

  save() {
    // console.log(this.productFg.value);
    this.productController.save(this.productFg.value)
      .subscribe((e: Product) => { console.log(e) });
    this.search();
  }

  onUpdateClick(product: Product) {
    this.productFg.patchValue(product);
    this.productFg.patchValue({ updateMode: true });
    //this.productFg.patchValue({id:product.id,name:product.name});
    console.log(this.productFg.value);
  }

  update() {
    this.productController.update(this.productFg.value)
      .subscribe((e) => {
        this.search();
      });
  }

  delete(product: Product) {
    this.productController.delete(product)
      .subscribe((e) => {
        this.search();
      });
  }

  search() {
    this.productList$ = this.productController
      .search(new ProductSearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.productList$);
  }

  reset() {
    this.productFg.reset();
  }

}