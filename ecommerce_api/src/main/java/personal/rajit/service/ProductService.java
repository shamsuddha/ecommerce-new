package personal.rajit.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.rajit.controller.request_dto.ProductSearchDto;
import personal.rajit.controller.request_dto.ProductSearchDto;
import personal.rajit.entity.Product;
import personal.rajit.entity.Product;
import personal.rajit.entity.QProduct;
import personal.rajit.repository.ProductRepository;
import personal.rajit.service.common.EntityValidationService;

import java.util.List;

import static personal.rajit.service.predicate.ProductPredicate.makePredicate;

@Service
@AllArgsConstructor
public class ProductService {
    private final EntityManager entityManager;
    private final EntityValidationService entityValidationService;
    private final ProductRepository productRepository;


    @org.springframework.transaction.annotation.Transactional
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @org.springframework.transaction.annotation.Transactional
    public Product updateProduct(Product product) {
        var productDb = entityValidationService.validateProduct(product.getId());
        productDb.setName(product.getName());
        productDb.setCode(product.getCode());
        productDb.setCurrentStock(product.getCurrentStock());
        productDb.setSellingPrice(product.getSellingPrice());
        productDb.setBuyingPrice(product.getBuyingPrice());
        productDb.setDescription(product.getDescription());
        productDb.setImage(product.getImage());
        productDb = productRepository.save(productDb);
        return productDb;
    }

    @org.springframework.transaction.annotation.Transactional
    public String deleteProduct(Product product) {
        var productDb = entityValidationService.validateProduct(product.getId());
        productDb.setEnabled(Boolean.FALSE);
        productRepository.save(productDb);
        return "Product deleted successfully";
    }

    public Page<Product> searchProduct(ProductSearchDto productSearchDto) {
        Predicate predicate = makePredicate(productSearchDto);
        Pageable pageable = PageRequest.of(productSearchDto.getPage(), productSearchDto.getSize());
        final QProduct qProduct = QProduct.product;
        var query = new JPAQuery<Product>(entityManager)
                .from(qProduct)
                .where(predicate)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(qProduct.createdDate.desc());
        return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
    }

}
