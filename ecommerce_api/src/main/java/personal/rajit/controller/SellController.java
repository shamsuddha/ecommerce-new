package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.SellSearchDto;
import personal.rajit.entity.Sell;
import personal.rajit.service.SellService;

@RestController
@RequestMapping("/sell")
@AllArgsConstructor
public class SellController {

    private final SellService sellService;

    @PostMapping("/save")
    public ResponseEntity<Sell> save(@RequestBody Sell sell) {
        return new ResponseEntity(sellService.saveSell(sell), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Sell> update(@RequestBody Sell sell) {
        return new ResponseEntity(sellService.updateSell(sell), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteSell(@RequestBody Sell sell) {
        return new ResponseEntity(sellService.deleteSell(sell), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Sell>> search(@RequestBody SellSearchDto sellSearchDto) {
        return new ResponseEntity(sellService.searchSell(sellSearchDto), HttpStatusCode.valueOf(200));
    }
}
