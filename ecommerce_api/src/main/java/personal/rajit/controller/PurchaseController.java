package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.PurchaseSearchDto;
import personal.rajit.entity.Purchase;
import personal.rajit.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
@AllArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity(purchaseService.savePurchase(purchase), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Purchase> update(@RequestBody Purchase purchase) {
        return new ResponseEntity(purchaseService.updatePurchase(purchase), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deletePurchase(@RequestBody Purchase purchase) {
        return new ResponseEntity(purchaseService.deletePurchase(purchase), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Purchase>> search(@RequestBody PurchaseSearchDto purchaseSearchDto) {
        return new ResponseEntity(purchaseService.searchPurchase(purchaseSearchDto), HttpStatusCode.valueOf(200));
    }

//    @PostMapping("/save-with-purchase-detail")
//    public ResponseEntity<Page<Purchase>> saveWithDetail(@RequestBody Purchase purchase) {
//        return new ResponseEntity(purchaseService.saveWithDetail(purchase), HttpStatusCode.valueOf(200));
//    }

}
