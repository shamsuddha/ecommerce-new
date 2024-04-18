package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.SellDetailSearchDto;
import personal.rajit.entity.SellDetail;
import personal.rajit.service.SellDetailService;

@RestController
@RequestMapping("/sell-detail")
@AllArgsConstructor
public class SellDetailController {
    private final SellDetailService sellDetailService;

    @PostMapping("/save")
    public ResponseEntity<SellDetail> save(@RequestBody SellDetail sellDetail) {
        return new ResponseEntity(sellDetailService.saveSellDetail(sellDetail), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<SellDetail> update(@RequestBody SellDetail sellDetail) {
        return new ResponseEntity(sellDetailService.updateSellDetail(sellDetail), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteSellDetail(@RequestBody SellDetail sellDetail) {
        return new ResponseEntity(sellDetailService.deleteSellDetail(sellDetail), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<SellDetail>> search(@RequestBody SellDetailSearchDto sellDetailSearchDto) {
        return new ResponseEntity(sellDetailService.searchSellDetail(sellDetailSearchDto), HttpStatusCode.valueOf(200));
    }
}
