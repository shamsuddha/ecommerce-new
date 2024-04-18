import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { RxFormBuilder, RxReactiveFormsModule } from '@rxweb/reactive-form-validators';
import { AgGridAngular } from 'ag-grid-angular';
import { Sell } from '../../../entity/Sell';
import { Observable, map } from 'rxjs';
import { SellController } from '../../../controller/SellController';
import { SellSearchDto } from '../../../controller/search_dto/SellSearchDto';

@Component({
 selector: 'SellComp',
 templateUrl: './SellComp.html',
 styleUrls: ['./SellComp.scss'],
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
export class SellComp implements OnInit {

  sellFg: FormGroup = this.rxFormBuilder.formGroup(Sell);
  //toFaGfn = toFaGfn;
  sellList$: Observable<Array<Sell>> = new Observable<Array<Sell>>();

  constructor(
    public sellController: SellController,
    public rxFormBuilder: RxFormBuilder
  ) { }

  ngOnInit(): void {
    this.search();
  }

  save() {
    // console.log(this.sellFg.value);
    this.sellController.save(this.sellFg.value)
      .subscribe((e: Sell) => { console.log(e) });
    this.search();
  }

  onUpdateClick(sell: Sell) {
    this.sellFg.patchValue(sell);
    this.sellFg.patchValue({ updateMode: true });
    //this.sellFg.patchValue({id:sell.id,name:sell.name});
    console.log(this.sellFg.value);
  }

  update() {
    this.sellController.update(this.sellFg.value)
      .subscribe((e) => {
        this.search();
      });
  }

  delete(sell: Sell) {
    this.sellController.delete(sell)
      .subscribe((e) => {
        this.search();
      });
  }

  search() {
    this.sellList$ = this.sellController
      .search(new SellSearchDto({ idList: [] }))
      .pipe(
        map(e => e.content)
      );
    console.log(this.sellList$);
  }

  reset() {
    this.sellFg.reset();
  }

}

