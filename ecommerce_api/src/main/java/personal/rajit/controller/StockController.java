package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.StockSearchDto;
import personal.rajit.entity.Stock;
import personal.rajit.service.StockService;

@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping("/save")
    public ResponseEntity<Stock> save(@RequestBody Stock stock) {
        return new ResponseEntity(stockService.saveStock(stock), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Stock> update(@RequestBody Stock stock) {
        return new ResponseEntity(stockService.updateStock(stock), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteStock(@RequestBody Stock stock) {
        return new ResponseEntity(stockService.deleteStock(stock), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Stock>> search(@RequestBody StockSearchDto stockSearchDto) {
        return new ResponseEntity(stockService.searchStock(stockSearchDto), HttpStatusCode.valueOf(200));
    }
}
