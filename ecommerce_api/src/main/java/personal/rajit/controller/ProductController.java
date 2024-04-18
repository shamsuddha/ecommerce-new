package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.ProductSearchDto;
import personal.rajit.entity.Product;
import personal.rajit.service.ProductService;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity(productService.saveProduct(product), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity(productService.updateProduct(product), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody Product product) {
        return new ResponseEntity(productService.deleteProduct(product), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Product>> search(@RequestBody ProductSearchDto productSearchDto) {
        return new ResponseEntity(productService.searchProduct(productSearchDto), HttpStatusCode.valueOf(200));
    }

}
