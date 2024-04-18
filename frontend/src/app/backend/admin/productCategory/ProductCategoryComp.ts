import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { ProductCategory } from '../../../entity/ProductCategory';
import { RxFormBuilder, RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { Observable, filter, map } from 'rxjs';
import { ProductCategoryController } from '../../../controller/ProductCategoryController';
import { NgSelectModule } from '@ng-select/ng-select';
import { HttpClientModule } from '@angular/common/http';
import { ProductCategorySearchDto } from '../../../controller/search_dto/ProductCategorySearchDto';

@Component({
  selector: 'ProductCategoryComp',
  templateUrl: './ProductCategoryComp.html',
  styleUrls: ['./ProductCategoryComp.scss'],
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    ReactiveFormsModule,
    RxReactiveFormsModule,
    NgSelectModule,
    HttpClientModule,
    //AgGridAngular,
    //PaginationModule
  ],
  providers: [

  ],
})
export class ProductCategoryComp implements OnInit {
  setPage(arg0: number) {
    throw new Error('Method not implemented.');
  }

  productCategoryFg: FormGroup = this.rxFormBuilder.formGroup(ProductCategory);
  //toFaGfn = toFaGfn;
  productCategoryList$: Observable<Array<ProductCategory>> = new Observable<Array<ProductCategory>>();
  //page?: number;

  constructor(
    public productCategoryController: ProductCategoryController,
    public rxFormBuilder: RxFormBuilder
  ) { }

  ngOnInit(): void {
    this.search();
  }

  save() {
    // console.log(this.productCategoryFg.value);
    this.productCategoryController.save(this.productCategoryFg.value)
      .subscribe((e: ProductCategory) => { console.log(e) });
    this.search();
  }

  onUpdateClick(productCategory: ProductCategory) {
    this.productCategoryFg.patchValue(productCategory);
    this.productCategoryFg.patchValue({ updateMode: true });
    //this.productCategoryFg.patchValue({id:productCategory.id,name:productCategory.name});
    console.log(this.productCategoryFg.value);
  }

  update() {
    this.productCategoryController.update(this.productCategoryFg.value)
      .subscribe((e) => {
        this.search();
      });
  }

  delete(productCategory: ProductCategory) {
    this.productCategoryController.delete(productCategory)
      .subscribe((e) => {
        this.search();
      });
  }

  search() {
    this.productCategoryList$ = this.productCategoryController
      .search(new ProductCategorySearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.productCategoryList$);
  }

  reset() {
    this.productCategoryFg.reset();
  }

  // pageChanged(event: PageChangedEvent): void {
  //   this.page = event.page;
  // }

}