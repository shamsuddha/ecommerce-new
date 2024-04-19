package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.PurchaseDetailSearchDto;
import personal.rajit.entity.PurchaseDetail;
import personal.rajit.service.PurchaseDetailService;

@RestController
@RequestMapping("/purchase-detail")
@AllArgsConstructor
public class PurchaseDetailController {
    private final PurchaseDetailService purchaseDetailService;

    @PostMapping("/save")
    public ResponseEntity<PurchaseDetail> save(@RequestBody PurchaseDetail purchaseDetail) {
        return new ResponseEntity(purchaseDetailService.savePurchaseDetail(purchaseDetail), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<PurchaseDetail> update(@RequestBody PurchaseDetail purchaseDetail) {
        return new ResponseEntity(purchaseDetailService.updatePurchaseDetail(purchaseDetail), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody PurchaseDetail purchaseDetail) {
        return new ResponseEntity(purchaseDetailService.deletePurchaseDetail(purchaseDetail), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<PurchaseDetail>> search(@RequestBody PurchaseDetailSearchDto purchaseDetailSearchDto) {
        return new ResponseEntity(purchaseDetailService.searchPurchaseDetail(purchaseDetailSearchDto), HttpStatusCode.valueOf(200));
    }

}
