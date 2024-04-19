import { Component, OnInit } from "@angular/core";
import { MatButtonModule } from "@angular/material/button";
import { MatDialogModule } from "@angular/material/dialog";
import { Observable, map } from "rxjs";
import { PurchaseDetail } from "../../../../entity/PurchaseDetail";
import { PurchaseDetailController } from "../../../../controller/PurchaseDetailController";
import { PurchaseDetailSearchDto } from "../../../../controller/search_dto/PurchaseDetailSearchDto";

@Component({
  selector: 'DialogComp',
  templateUrl: 'DialogComp.html',
  standalone: true,
  imports: [MatDialogModule, MatButtonModule],
})
export class DialogComp implements OnInit {

  purchaseDetailList$: Observable<Array<PurchaseDetail>> = new Observable<Array<PurchaseDetail>>();

  constructor(
    public purchaseDetailController: PurchaseDetailController
  ) { }

  ngOnInit(): void {

    // this.purchaseDetailList$ = this.purchaseDetailController.searchWithPurchaseAndProduct(purchase: Purchase)
    //   .pipe(
    //     map(e => e.content.filter((e) => e.enabled == true))
    //   );
  }

}