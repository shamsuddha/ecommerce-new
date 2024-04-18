package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.SupplierSearchDto;
import personal.rajit.entity.Supplier;
import personal.rajit.service.SupplierService;

@RestController
@RequestMapping("/supplier")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("/save")
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier) {
        return new ResponseEntity(supplierService.saveSupplier(supplier), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Supplier> update(@RequestBody Supplier supplier) {
        return new ResponseEntity(supplierService.updateSupplier(supplier), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteSupplier(@RequestBody Supplier supplier) {
        return new ResponseEntity(supplierService.deleteSupplier(supplier), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Supplier>> search(@RequestBody SupplierSearchDto supplierSearchDto) {
        return new ResponseEntity(supplierService.searchSupplier(supplierSearchDto), HttpStatusCode.valueOf(200));
    }

}
