package personal.rajit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.rajit.controller.request_dto.ProductCategorySearchDto;
import personal.rajit.entity.ProductCategory;
import personal.rajit.service.ProductCategoryService;

@RestController
@RequestMapping("/product-category")
@AllArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @PostMapping("/save")
    public ResponseEntity<ProductCategory> save(@RequestBody ProductCategory productCategory) {
        return new ResponseEntity(productCategoryService.saveProductCategory(productCategory), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<ProductCategory> update(@RequestBody ProductCategory productCategory) {
        return new ResponseEntity(productCategoryService.updateProductCategory(productCategory), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody ProductCategory productCategory) {
        return new ResponseEntity(productCategoryService.deleteProductCategory(productCategory), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/search")
    public ResponseEntity<Page<ProductCategory>> search(@RequestBody ProductCategorySearchDto productCategorySearchDto) {
        return new ResponseEntity(productCategoryService.searchProductCategory(productCategorySearchDto), HttpStatusCode.valueOf(200));
    }

}
